package com.zw.cf.controller;

import com.zw.cf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller("helloWorld")
@RequestMapping("/app")
public class HelloWorld{

	@RequestMapping("/1")
	public String printHello(ModelMap model) {
		UserCtrl userCtrl=new UserCtrl();
		User u=new User("111111","name3333","s");
		userCtrl.setUser(u);
		//userCtrl.add();

		return "app1";
	}

}
