package com.zw.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller("helloWorld")
@RequestMapping("/app")
public class HelloWorld{

	@RequestMapping("/1")
	public String printHello(ModelMap model) {
		return "app";
	}

}
