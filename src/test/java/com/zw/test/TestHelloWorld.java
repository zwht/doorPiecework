package com.zw.test;

import com.zw.cf.controller.UserCtrl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhaowei on 2017/6/24.
 */
public class TestHelloWorld {
    //创建Spring的工厂
    private BeanFactory factory = new ClassPathXmlApplicationContext("spring-context.xml");


    @Test
    public void testUser(){
        UserCtrl ua=factory.getBean("userAction",UserCtrl.class);
        //ua.setUser(u);
        //ua.add();
    }
}
