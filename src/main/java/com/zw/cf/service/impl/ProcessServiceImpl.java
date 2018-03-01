package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.ProcessMapper;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.*;
import com.zw.cf.model.Process;
import com.zw.cf.service.ProcessService;
import com.zw.cf.vo.ProcessListFind;
import com.zw.cf.vo.ProcessVo;
import com.zw.cf.vo.SalaryListFind;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    UserMapper userMapper;

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

    public Response addList(List<Process> list) {
        Response response = new Response();
        try {
            Date date = new Date();
            for (int i = 0; i < list.size(); i++) {
                Process process=list.get(i);
                if(process.getId()==null||process.getId().equals("")){
                    process.setId(date.getTime() +i+ "");
                    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                    Validator validator = factory.getValidator();
                    Set<ConstraintViolation<Process>> constraintViolations = validator.validate(process);
                    if (constraintViolations.size() != 0) {
                        return response.validation(constraintViolations);
                    } else {
                        processMapper.insert(process);
                    }
                }else {
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
                    }
                }


            }
            return response.success(list);
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
        String ticketId = processListFind.getTicketId();
        if (ticketId == null || ticketId.equals("")) {
        } else {
            criteria.andTicketIdEqualTo(ticketId);
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

    public Response salary(Integer pageNum, Integer pageSize, SalaryListFind salaryListFind) {
        Response response = new Response();

        Date startDate = new Date(salaryListFind.getStartTime());
        Date endDate = new Date(salaryListFind.getEndTime());
        //条件查询3句话
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andEndTimeBetween(startDate, endDate);
        criteria.andStateEqualTo(2);
        criteria.andCorporationIdEqualTo(salaryListFind.getCorporationId());
        List<Process> processList = processMapper.selectByExample(processExample);

        Map<String, Process> processMap = new HashMap();

        for (Process process : processList) {
            String id = process.getUserId();
            if (processMap.containsKey(id)) {
                Process p = processMap.get(id);
                p.setPrice(p.getPrice()+process.getPrice());
            }else{
                processMap.put(id,process);
            }
        }


        try {
            PageObj pageObj = new PageObj();
            UserExample userExample = new UserExample();
            UserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andRolesEqualTo("4");
            userCriteria.andCorporationIdEqualTo(salaryListFind.getCorporationId());
            Page page = PageHelper.startPage(pageNum, pageSize);
            List<User> userList = userMapper.selectByExample(userExample);
            long count = page.getTotal();

            List<ProcessVo> processVos= new ArrayList<ProcessVo>();
            for( User user: userList){
                Gx gx = new Gx();
                if(processMap.containsKey(user.getId())){
                    Process process=processMap.get(user.getId());
                    processVos.add(new ProcessVo(gx,user,process));
                }
            }


            return response.success(pageObj.init(pageNum, pageSize, count, processVos));
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
