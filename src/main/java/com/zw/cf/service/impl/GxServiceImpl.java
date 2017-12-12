package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.GxMapper;
import com.zw.cf.model.Gx;
import com.zw.cf.model.GxExample;
import com.zw.cf.service.GxService;
import com.zw.cf.vo.GxListFind;
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
public class GxServiceImpl implements GxService {
    @Autowired
    GxMapper gxMapper;

    public Response add(Gx gx) {
        Response response = new Response();
        try {
            Date date = new Date();
            GxExample gxExample=new GxExample();
            GxExample.Criteria criteria=gxExample.createCriteria();
            criteria.andNameEqualTo(gx.getName());
            //使用用户名查询是否有相同用户名
            List<Gx> gxs = gxMapper.selectByExample(gxExample);
            if (gxs.size() == 0) {
                gx.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Gx>> constraintViolations= validator.validate(gx);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    gxMapper.insert(gx);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, GxListFind gxListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        GxExample gxExample = new GxExample();
        GxExample.Criteria criteria = gxExample.createCriteria();
        String name = gxListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = gxMapper.selectByExample(gxExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(gxMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Gx gx) {
        Response response = new Response();
        try {
            GxExample gxExample = new GxExample();
            GxExample.Criteria criteria = gxExample.createCriteria();
            criteria.andNameEqualTo(gx.getName());
            criteria.andIdNotEqualTo(gx.getId());
            //使用用户名查询是否有相同用户名
            List<Gx> corporations = gxMapper.selectByExample(gxExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Gx>> constraintViolations = validator.validate(gx);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    GxExample example = new GxExample();
                    GxExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(gx.getId());
                    gxMapper.updateByExampleSelective(gx, example);
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
