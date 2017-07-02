package com.zw.test;

import com.zw.cf.controller.UserCtrl;
import com.zw.cf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zw.cf.controller.HelloWorld;

/**
 * Created by zhaowei on 2017/6/24.
 */
public class TestHelloWorld {
    //创建Spring的工厂
    private BeanFactory factory = new ClassPathXmlApplicationContext("spring-context.xml");

    @Test
    public  void  testHello(){
        //通过工厂获取Spring的对象
        //此处getBean中的helloWorld就是spring-context.xml配置文件中的id
        HelloWorld hello= factory.getBean("helloWorld",HelloWorld.class);

        //System.out.println(hello.printHello());

        HelloWorld hello1= factory.getBean("helloWorld",HelloWorld.class);

        //在bean配置文件里面
        //scope="singleton",为单例模式，true
        //scope="prototype",为多例模式，false
        System.out.println(hello==hello1);
    }
    @Test
    public void testUser(){
        UserCtrl ua=factory.getBean("userAction",UserCtrl.class);
        User u=new User("id999","name3333","sss");
        ua.setUser(u);
        //ua.add();
    }
}
