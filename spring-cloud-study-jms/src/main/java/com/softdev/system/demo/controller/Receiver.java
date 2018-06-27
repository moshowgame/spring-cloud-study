package com.softdev.system.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.softdev.system.demo.entity.Email;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

}
