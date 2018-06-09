package com.softdev.system.feign.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softdev.system.feign.util.ApiReturnObject;
import com.softdev.system.feign.util.ApiReturnUtil;
import com.softdev.system.feign.util.BasePath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class FeignController {
	@Autowired
	DemoRemoteClient demoRemoteClient;
	
	@GetMapping("/remote/demo/getData/{uid}")
	public ApiReturnObject  basePath(@PathVariable String uid ,String data){
		return demoRemoteClient.getData(uid, data);
	}
}
