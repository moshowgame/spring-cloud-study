package com.softdev.system.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

@Api("DEMO接口")
@Controller
public class DemoController {
	@ResponseBody
	@GetMapping("/index")
	@ApiOperation(value="index", notes="返回json数据")
	@ApiImplicitParam(name = "data", value = "object内容", required = true, dataType = "String")
	public ApiReturnObject  index(String data){
		if(StringUtils.isEmpty(data)) {
			data="hello spring-cloud-study";
		}
		return ApiReturnUtil.success(data);
	}
	@ApiOperation(value="socket", notes="访问socket页面")
	@GetMapping("/socket/{cid}")
	public ModelAndView  sockethtml(@PathVariable String cid){
		ModelAndView mav=new ModelAndView("socket");
		mav.addObject("cid", cid);
		return mav;
	}
	@ApiOperation(value="basePath", notes="获取basepath")
	@GetMapping("/basepath")
	@ResponseBody
	public ApiReturnObject  basePath(HttpServletRequest request){
		return ApiReturnUtil.success(BasePath.getBasePath(request));
	}
	
	@GetMapping("/getData/{uid}")
	@ResponseBody
	public ApiReturnObject getData(@PathVariable String uid,String data){
		System.out.println("#spring-cloud-study-demo#");
		System.out.println("uid->"+uid+",data->"+data);
		Map<String,String> map=new HashMap<String,String>();
		map.put(uid,data);
		map.put("feign","远程调用微服务");
		map.put("demo","本地微服务");
		return ApiReturnUtil.success(map);
	}
}
