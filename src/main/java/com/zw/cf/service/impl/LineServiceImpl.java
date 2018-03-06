package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.GxMapper;
import com.zw.cf.dao.LineMapper;
import com.zw.cf.model.Gx;
import com.zw.cf.model.GxExample;
import com.zw.cf.model.Line;
import com.zw.cf.model.LineExample;
import com.zw.cf.service.LineService;
import com.zw.cf.vo.LineListFind;
import com.zw.cf.vo.LineVo;
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
public class LineServiceImpl implements LineService {
    @Autowired
    LineMapper lineMapper;
    @Autowired
    GxMapper gxMapper;


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
        criteria.andCorporationIdEqualTo(lineListFind.getCorporationId());

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List<Line> list = lineMapper.selectByExample(lineExample);
            long count = page.getTotal();


            List<LineVo> lineList = new ArrayList<LineVo>();

            List<Gx> gxList = gxMapper.selectByExample(new GxExample());
            Map<String, Gx> gxListObj = new HashMap<String, Gx>();
            for (Gx gx : gxList) {
                gxListObj.put(gx.getId(), gx);
            }
            for (Line item : list) {
                List<Gx> gxListObj1 = new ArrayList<Gx>();
                String[] ss = item.getGxIds().split(",");
                String[] ss1 = item.getGxValues().split(",");
                for(int i = 0; i < ss.length; i++){
                    Gx gx1=new Gx();
                    gx1.setId(gxListObj.get(ss[i]).getId());
                    gx1.setCorporationId(gxListObj.get(ss[i]).getCorporationId());
                    gx1.setName(gxListObj.get(ss[i]).getName());
                    gx1.setPrice(Integer.valueOf(ss1[i]).intValue());
                    gxListObj1.add(gx1);
                }

                lineList.add(new LineVo(gxListObj1, item));
            }
            return response.success(pageObj.init(pageNum, pageSize, count, lineList));

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
    public Response del(String id) {
        Response response = new Response();
        try {
            return response.success(lineMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
