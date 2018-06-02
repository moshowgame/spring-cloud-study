package com.softdev.system.configcenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsController {

	@Value("${system.miniprogram}")  
    private String miniProgramUrl;  
	
	@RequestMapping("/getparam")  
    public String getparam() {  
        return miniProgramUrl;  
    }  
}
