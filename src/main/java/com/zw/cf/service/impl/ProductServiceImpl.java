package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.ProductMapper;
import com.zw.cf.model.Product;
import com.zw.cf.model.ProductExample;
import com.zw.cf.service.ProductService;
import com.zw.cf.vo.ProductListFind;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    public Response add(Product product) {
        Response response = new Response();
        try {
            Date date = new Date();
            ProductExample productExample=new ProductExample();
            ProductExample.Criteria criteria=productExample.createCriteria();
            criteria.andNameEqualTo(product.getName());
            //使用用户名查询是否有相同用户名
            List<Product> products = productMapper.selectByExample(productExample);
            if (products.size() == 0) {
                product.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Product>> constraintViolations= validator.validate(product);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    productMapper.insert(product);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, ProductListFind productListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        String name = productListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = productMapper.selectByExample(productExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(productMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Product product) {
        Response response = new Response();
        try {
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria = productExample.createCriteria();
            criteria.andNameEqualTo(product.getName());
            criteria.andIdNotEqualTo(product.getId());
            //使用用户名查询是否有相同用户名
            List<Product> corporations = productMapper.selectByExample(productExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ProductExample example = new ProductExample();
                    ProductExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(product.getId());
                    productMapper.updateByExampleSelective(product, example);
                    //corporationMapper.insert(corporation);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }
}
