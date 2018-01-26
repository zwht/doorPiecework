package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.ProcessMapper;
import com.zw.cf.model.Process;
import com.zw.cf.model.ProcessExample;
import com.zw.cf.service.ProcessService;
import com.zw.cf.vo.ProcessListFind;
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
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    public Response add(Process process) {
        Response response = new Response();
        try {
            Date date = new Date();
            ProcessExample processExample=new ProcessExample();
            ProcessExample.Criteria criteria=processExample.createCriteria();
            //criteria.andNameEqualTo(process.getName());
            //使用用户名查询是否有相同用户名
            List<Process> processs = processMapper.selectByExample(processExample);
            if (processs.size() == 0) {
                process.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Process>> constraintViolations= validator.validate(process);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    processMapper.insert(process);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, ProcessListFind processListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        String name = processListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            //criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = processMapper.selectByExample(processExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(processMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Process process) {
        Response response = new Response();
        try {
            ProcessExample processExample = new ProcessExample();
            ProcessExample.Criteria criteria = processExample.createCriteria();
            //criteria.andNameEqualTo(process.getName());
            criteria.andIdNotEqualTo(process.getId());
            //使用用户名查询是否有相同用户名
            List<Process> corporations = processMapper.selectByExample(processExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Process>> constraintViolations = validator.validate(process);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ProcessExample example = new ProcessExample();
                    ProcessExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(process.getId());
                    processMapper.updateByExampleSelective(process, example);
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
            return response.success(processMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
