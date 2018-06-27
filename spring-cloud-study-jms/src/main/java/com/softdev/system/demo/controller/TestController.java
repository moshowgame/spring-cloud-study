package com.softdev.system.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.demo.entity.Email;

@RestController
public class TestController {
	@Autowired
	private JmsTemplate jmsTemplate;
    
    /**
     * 发送订阅
     */
    @GetMapping("/email/send")
    public Email updateItem(Email item) {
    	jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    	return item;
    }
}
