package com.softdev.system.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;

@RestController
public class PortController {
	   
		@RequestMapping("/putdata")
		public ApiReturnObject  putdata(){
			return ApiReturnUtil.success("放置数据成功");
		}
}
