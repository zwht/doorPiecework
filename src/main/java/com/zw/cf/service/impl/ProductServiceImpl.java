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
import java.util.ArrayList;
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
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria = productExample.createCriteria();
            criteria.andNameEqualTo(product.getName());
            //使用用户名查询是否有相同用户名

            List<Product> products = productMapper.selectByExample(productExample);
            if (products.size() == 0) {
                product.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    productMapper.insert(product);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response addList(List<Product> list) {
        Response response = new Response();
        try {
            Date date = new Date();
            for (int i = 0; i < list.size(); i++) {
                Product product = list.get(i);
                if (product.getId() == null || product.getId().equals("")) {
                    product.setId(date.getTime() + i + "");
                    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                    Validator validator = factory.getValidator();
                    Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
                    if (constraintViolations.size() != 0) {
                        return response.validation(constraintViolations);
                    } else {
                        productMapper.insert(product);
                    }
                } else {
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
                    }
                }


            }
            return response.success(list);
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response list(Integer pageNum, Integer pageSize, ProductListFind productListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        String ticketId = productListFind.getTicketId();
        if (ticketId == null || ticketId.equals("")) {
        } else {
            criteria.andTicketIdEqualTo(ticketId);
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
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response del(String id) {
        Response response = new Response();
        try {
            return response.success(productMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
