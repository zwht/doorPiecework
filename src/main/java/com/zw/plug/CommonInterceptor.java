package com.zw.plug;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zw.cf.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by zhaowei on 2017/6/29.
 */

/**
 * @author tfj
 * 2014-8-1
 */
public class CommonInterceptor extends HandlerInterceptorAdapter{
    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    @ResponseBody
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {

            //RequestUtil.saveRequest();
        }
        log.info("==============执行顺序: 1、preHandle================");

        String requestUri = request.getRequestURI();
        String[] noToken=new String[]{
                "/cfmy/user/login",
                "/cfmy/code/list",
                "/cfmy/file/upToken"
        };
        int key=0;
        for (int i = 0; i < noToken.length; i++) {
            if(requestUri.indexOf(noToken[i])!=-1) {
                key=1;
            }
        }
        if(key==1) return true;

        String token = request.getHeader("Authorization");
        if(token==null){
            token = request.getParameter("Authorization");
        }

        if(token!=null){
            if(TokenUtil.getToken(token)){
                return true;
            }
        }

        Response response1=new Response();
        response1.failure(412, "没有权限，请登录");
        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonStr = objectMapper.writeValueAsString(response1);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(userJsonStr);
        return false;

    }
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("==============执行顺序: 2、postHandle================");
        if(modelAndView != null){  //加入当前时间
            modelAndView.addObject("var", "测试postHandle");
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("==============执行顺序: 3、afterCompletion================");
    }

}