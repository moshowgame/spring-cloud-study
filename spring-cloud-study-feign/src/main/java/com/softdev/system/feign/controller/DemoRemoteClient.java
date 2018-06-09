package com.softdev.system.feign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.softdev.system.feign.util.ApiReturnObject;

@FeignClient(name = "spring-cloud-study-demo")
public interface DemoRemoteClient {
	
	@GetMapping("/demo/getData/{uid}")
	public ApiReturnObject getData(@PathVariable(value="uid") String uid,@RequestParam(value="data") String data);

}
