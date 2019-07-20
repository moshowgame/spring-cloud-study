package com.softdev.system.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@GetMapping("index")
	public ModelAndView  index(){
		return new ModelAndView("index");
	}
	@GetMapping("login")
	public ModelAndView  login(String error){
		return new ModelAndView("login").addObject("error",error);
	}

	@GetMapping("user/list")
	public ModelAndView  userList(){
		return new ModelAndView("user-list");
	}
}
