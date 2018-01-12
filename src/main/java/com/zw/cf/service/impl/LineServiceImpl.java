package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.LineMapper;
import com.zw.cf.model.Line;
import com.zw.cf.model.LineExample;
import com.zw.cf.service.LineService;
import com.zw.cf.vo.LineListFind;
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
public class LineServiceImpl implements LineService {
    @Autowired
    LineMapper lineMapper;

    public Response add(Line line) {
        Response response = new Response();
        try {
            Date date = new Date();
            LineExample lineExample=new LineExample();
            LineExample.Criteria criteria=lineExample.createCriteria();
            criteria.andNameEqualTo(line.getName());
            //使用用户名查询是否有相同用户名
            List<Line> lines = lineMapper.selectByExample(lineExample);
            if (lines.size() == 0) {
                line.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Line>> constraintViolations= validator.validate(line);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    lineMapper.insert(line);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, LineListFind lineListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        LineExample lineExample = new LineExample();
        LineExample.Criteria criteria = lineExample.createCriteria();
        String name = lineListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = lineMapper.selectByExample(lineExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(lineMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Line line) {
        Response response = new Response();
        try {
            LineExample lineExample = new LineExample();
            LineExample.Criteria criteria = lineExample.createCriteria();
            criteria.andNameEqualTo(line.getName());
            criteria.andIdNotEqualTo(line.getId());
            //使用用户名查询是否有相同用户名
            List<Line> corporations = lineMapper.selectByExample(lineExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Line>> constraintViolations = validator.validate(line);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    LineExample example = new LineExample();
                    LineExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(line.getId());
                    lineMapper.updateByExampleSelective(line, example);
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
