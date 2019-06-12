package com.softdev.system.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.RandomUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;
import com.softdev.system.demo.util.BasePath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class IndexController {
	@GetMapping("/index")
	public ModelAndView  index(){
		ModelAndView mav=new ModelAndView("socket");
		mav.addObject("uid", RandomUtil.randomInt(6));
		return mav;
	}
}
