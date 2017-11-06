package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.CorporationMapper;
import com.zw.cf.model.CorporationExample;
import com.zw.cf.model.Corporation;
import com.zw.cf.service.CorporationService;
import com.zw.cf.vo.CorporationListFind;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import com.zw.plug.ZwUtil;
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
 * Created by zhaowei on 2017/10/23.
 */
@Service
public class CorporationServiceImp implements CorporationService {
    @Autowired
    CorporationMapper corporationMapper;

    public Response getCorporationById(String id) {
        Response response = new Response();
        try {
            return response.success(corporationMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response addCorporation(Corporation corporation) {
        Response response = new Response();
        try {
            Date date = new Date();
            CorporationExample corporationExample = new CorporationExample();
            CorporationExample.Criteria criteria = corporationExample.createCriteria();
            criteria.andNameEqualTo(corporation.getName());
            //使用用户名查询是否有相同用户名
            List<Corporation> corporations = corporationMapper.selectByExample(corporationExample);
            if (corporations.size() == 0) {
                corporation.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Corporation>> constraintViolations = validator.validate(corporation);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    corporationMapper.insert(corporation);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "已经有相同名字公司！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }

    public Response getCorporationList(Integer pageNum, Integer pageSize, CorporationListFind corporationListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        CorporationExample corporationExample = new CorporationExample();
        CorporationExample.Criteria criteria = corporationExample.createCriteria();
        String name=corporationListFind.getName();
        if(name == null || name.equals("")){}else{
            criteria.andNameEqualTo(name);
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = corporationMapper.selectByExample(corporationExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response del(String id) {
        Response response = new Response();
        try {
            return response.success(corporationMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
