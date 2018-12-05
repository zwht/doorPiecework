package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.ProcessMapper;
import com.zw.cf.dao.ProductMapper;
import com.zw.cf.dao.TicketMapper;
import com.zw.cf.model.*;
import com.zw.cf.model.Process;
import com.zw.cf.service.TicketService;
import com.zw.cf.vo.TicketListFind;
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
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketMapper ticketMapper;
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    ProductMapper productMapper;

    public Response add(Ticket ticket) {
        Response response = new Response();
        try {
            Date date = new Date();
            TicketExample ticketExample = new TicketExample();
            TicketExample.Criteria criteria = ticketExample.createCriteria();

            Page page = PageHelper.startPage(1, 1);
            List list = ticketMapper.selectByExample(ticketExample);
            long count = page.getTotal();
            ticket.setName((count + 1) + "_" + date.getTime());
            criteria.andNameEqualTo(ticket.getName());
            //使用用户名查询是否有相同用户名
            List<Ticket> tickets = ticketMapper.selectByExample(ticketExample);
            if (tickets.size() == 0) {
                ticket.setId(date.getTime() + "");
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Ticket>> constraintViolations = validator.validate(ticket);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ticketMapper.insert(ticket);
                    String id = ticket.getId();
                    return response.success(ticket);
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response list(Integer pageNum, Integer pageSize, TicketListFind ticketListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        TicketExample ticketExample = new TicketExample();
        TicketExample.Criteria criteria = ticketExample.createCriteria();
        String name = ticketListFind.getName();
        String dealersId = ticketListFind.getDealersId();
        List<Integer> state = ticketListFind.getState();

        if (name != null && !name.equals("")) {
            criteria.andNameEqualTo(name);
        }
        if (dealersId != null && !dealersId.equals("")) {
            criteria.andDealersIdEqualTo(dealersId);
        }
        if (state != null && !state.isEmpty()) {
            criteria.andStateIn(state);
        }

        criteria.andCorporationIdEqualTo(ticketListFind.getCorporationId());

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = ticketMapper.selectByExample(ticketExample);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response getById(String id) {
        Response response = new Response();
        try {
            return response.success(ticketMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response update(Ticket ticket) {
        Response response = new Response();
        try {
            TicketExample ticketExample = new TicketExample();
            TicketExample.Criteria criteria = ticketExample.createCriteria();
            criteria.andNameEqualTo(ticket.getName());
            criteria.andIdNotEqualTo(ticket.getId());
            //使用用户名查询是否有相同用户名
            List<Ticket> corporations = ticketMapper.selectByExample(ticketExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Ticket>> constraintViolations = validator.validate(ticket);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    TicketExample example = new TicketExample();
                    TicketExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(ticket.getId());
                    ticketMapper.updateByExampleSelective(ticket, example);
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

    public Response updateState(String id, Integer state) {
        Response response = new Response();
        try {
            TicketExample example = new TicketExample();
            TicketExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);

            Date date = new Date();
            Ticket ticket = new Ticket();
            ticket.setId(id);
            ticket.setState(state);
            if (state.equals(1050)) ticket.setOverTime(date);
            ticketMapper.updateByExampleSelective(ticket, example);

            //如果状态为800，生产完成，应修改进程状态计算工资
            if (state.equals(1050)) {
                //条件查询3句话
                ProcessExample processExample = new ProcessExample();
                ProcessExample.Criteria criteria1 = processExample.createCriteria();
                criteria1.andTicketIdEqualTo(id);
                List<Process> processList = processMapper.selectByExample(processExample);
                for (Process process : processList) {
                    ProcessExample example1 = new ProcessExample();
                    ProcessExample.Criteria criteria2 = example1.createCriteria();
                    criteria2.andIdEqualTo(process.getId());
                    process.setEndTime(date);
                    process.setState(2);
                    processMapper.updateByExampleSelective(process, example1);
                }
            }
            return response.success("修改成功");
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    public Response del(String id) {
        Response response = new Response();
        try {

            ProcessExample processExample = new ProcessExample();
            ProcessExample.Criteria processCriteria = processExample.createCriteria();
            processCriteria.andTicketIdEqualTo(id);
            processMapper.deleteByExample(processExample);

            ProductExample productExample = new ProductExample();
            ProductExample.Criteria productCriteria = productExample.createCriteria();
            productCriteria.andTicketIdEqualTo(id);
            productMapper.deleteByExample(productExample);

            return response.success(ticketMapper.deleteByPrimaryKey(id));

        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}
