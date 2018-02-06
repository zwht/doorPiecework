package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.ColorMapper;
import com.zw.cf.model.Color;
import com.zw.cf.model.ColorExample;
import com.zw.cf.service.ColorService;
import com.zw.cf.vo.ColorListFind;
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
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorMapper colorMapper;

    public Response add(Color color) {
        Response response = new Response();
        try {
            Date date = new Date();
            ColorExample colorExample=new ColorExample();
            ColorExample.Criteria criteria=colorExample.createCriteria();
            criteria.andNameEqualTo(color.getName());
            //使用用户名查询是否有相同用户名
            List<Color> colors = colorMapper.selectByExample(colorExample);
            if (colors.size() == 0) {
                color.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Color>> constraintViolations= validator.validate(color);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    colorMapper.insert(color);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, ColorListFind colorListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        ColorExample colorExample = new ColorExample();
        ColorExample.Criteria criteria = colorExample.createCriteria();
        String name = colorListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }
        criteria.andCorporationIdEqualTo(colorListFind.getCorporationId());

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = colorMapper.selectByExample(colorExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(colorMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Color color) {
        Response response = new Response();
        try {
            ColorExample colorExample = new ColorExample();
            ColorExample.Criteria criteria = colorExample.createCriteria();
            criteria.andNameEqualTo(color.getName());
            criteria.andIdNotEqualTo(color.getId());
            //使用用户名查询是否有相同用户名
            List<Color> corporations = colorMapper.selectByExample(colorExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Color>> constraintViolations = validator.validate(color);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ColorExample example = new ColorExample();
                    ColorExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(color.getId());
                    colorMapper.updateByExampleSelective(color, example);
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

    public Response del(String id) {
        Response response = new Response();
        try {
            return response.success(colorMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
