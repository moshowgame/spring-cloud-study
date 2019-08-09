package com.softdev.system.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }
}
