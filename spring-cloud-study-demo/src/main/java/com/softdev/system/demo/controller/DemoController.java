package com.softdev.system.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;

@RestController
public class DemoController {
	   
		@RequestMapping("/index")
		public ApiReturnObject  index(){
			return ApiReturnUtil.success("welcome to demo");
		}
}
