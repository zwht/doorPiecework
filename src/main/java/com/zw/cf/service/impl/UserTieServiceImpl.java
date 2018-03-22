package com.zw.cf.service.impl;

import com.zw.cf.dao.UserTieMapper;
import com.zw.cf.model.UserTie;
import com.zw.cf.model.UserTieExample;
import com.zw.cf.service.UserTieService;
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
public class UserTieServiceImpl implements UserTieService {
    @Autowired
    UserTieMapper userTieMapper;

    public Response add(UserTie userTie) {
        Response response = new Response();
        try {
            Date date = new Date();
            UserTieExample userTieExample=new UserTieExample();
            UserTieExample.Criteria criteria=userTieExample.createCriteria();
            criteria.andDealersIdEqualTo(userTie.getDealersId());
            //使用用户名查询是否有相同用户名
            List<UserTie> userTies = userTieMapper.selectByExample(userTieExample);
            if (userTies.size() == 0) {
                userTie.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<UserTie>> constraintViolations= validator.validate(userTie);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    userTieMapper.insert(userTie);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(userTieMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(UserTie userTie) {
        Response response = new Response();
        try {
            UserTieExample userTieExample = new UserTieExample();
            UserTieExample.Criteria criteria = userTieExample.createCriteria();
            criteria.andIdNotEqualTo(userTie.getId());
            //使用用户名查询是否有相同用户名
            List<UserTie> corporations = userTieMapper.selectByExample(userTieExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<UserTie>> constraintViolations = validator.validate(userTie);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    UserTieExample example = new UserTieExample();
                    UserTieExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(userTie.getId());
                    userTieMapper.updateByExampleSelective(userTie, example);
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
            return response.success(userTieMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
