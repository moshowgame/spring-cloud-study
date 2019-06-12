package com.softdev.system.demo.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping("/index")
	public ModelAndView  index(){
		ModelAndView mav=new ModelAndView("socket");
		mav.addObject("uid", RandomUtil.randomNumbers(6));
		return mav;
	}
}
