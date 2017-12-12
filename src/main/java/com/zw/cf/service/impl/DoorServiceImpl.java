package com.zw.cf.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.DoorMapper;
import com.zw.cf.model.Door;
import com.zw.cf.model.DoorExample;
import com.zw.cf.service.DoorService;
import com.zw.cf.vo.DoorListFind;
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
public class DoorServiceImpl implements DoorService {
    @Autowired
    DoorMapper doorMapper;

    public Response add(Door door) {
        Response response = new Response();
        try {
            Date date = new Date();
            DoorExample doorExample=new DoorExample();
            DoorExample.Criteria criteria=doorExample.createCriteria();
            criteria.andNameEqualTo(door.getName());
            //使用用户名查询是否有相同用户名
            List<Door> doors = doorMapper.selectByExample(doorExample);
            if (doors.size() == 0) {
                door.setId(date.getTime() + "");
                door.setCreateTime(date);
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Door>> constraintViolations= validator.validate(door);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    doorMapper.insert(door);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response list(Integer pageNum, Integer pageSize, DoorListFind doorListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        DoorExample doorExample = new DoorExample();
        DoorExample.Criteria criteria = doorExample.createCriteria();
        String name = doorListFind.getName();
        if (name == null || name.equals("")) {
        } else {
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = doorMapper.selectByExample(doorExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(doorMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Door door) {
        Response response = new Response();
        try {
            DoorExample doorExample = new DoorExample();
            DoorExample.Criteria criteria = doorExample.createCriteria();
            criteria.andNameEqualTo(door.getName());
            criteria.andIdNotEqualTo(door.getId());
            //使用用户名查询是否有相同用户名
            List<Door> corporations = doorMapper.selectByExample(doorExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Door>> constraintViolations = validator.validate(door);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    DoorExample example = new DoorExample();
                    DoorExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(door.getId());
                    doorMapper.updateByExampleSelective(door, example);
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
