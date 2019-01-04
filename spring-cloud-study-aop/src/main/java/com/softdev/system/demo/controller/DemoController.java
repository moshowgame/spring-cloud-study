package com.softdev.system.demo.controller;

import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/index")
	public ApiReturnObject index(String data){
		if(StringUtils.isEmpty(data)) {
			data="hello spring-cloud-study";
		}
		return ApiReturnUtil.success(data);
	}

}
