package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.CodeMapper;
import com.zw.cf.model.Code;
import com.zw.cf.model.CodeExample;
import com.zw.cf.service.CodeService;
import com.zw.cf.vo.CodeListFind;
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
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeMapper codeMapper;

    public Response add(Code code) {
        Response response = new Response();
        try {
            Date date = new Date();
            CodeExample codeExample=new CodeExample();
            CodeExample.Criteria criteria=codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            //使用用户名查询是否有相同用户名
            List<Code> codes = codeMapper.selectByExample(codeExample);
            if (codes.size() == 0) {
                code.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations= validator.validate(code);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    codeMapper.insert(code);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response list(Integer pageNum, Integer pageSize, CodeListFind codeListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        CodeExample codeExample = new CodeExample();
        CodeExample.Criteria criteria = codeExample.createCriteria();
        String name = codeListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = codeMapper.selectByExample(codeExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(codeMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Code code) {
        Response response = new Response();
        try {
            CodeExample codeExample = new CodeExample();
            CodeExample.Criteria criteria = codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            criteria.andIdNotEqualTo(code.getId());
            //使用用户名查询是否有相同用户名
            List<Code> corporations = codeMapper.selectByExample(codeExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations = validator.validate(code);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    CodeExample example = new CodeExample();
                    CodeExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(code.getId());
                    codeMapper.updateByExampleSelective(code, example);
                    //corporationMapper.insert(corporation);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response del(String id) {
        Response response = new Response();
        try {
            return response.success(codeMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
