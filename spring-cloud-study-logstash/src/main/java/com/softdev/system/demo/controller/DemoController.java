package com.softdev.system.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoController {

	private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping
    public Object index(){
        String msg="Oh My God ,System Error when "+ DateUtil.now();
        log.error(msg);
        return ResponseEntity.ok(msg);
    }
}
