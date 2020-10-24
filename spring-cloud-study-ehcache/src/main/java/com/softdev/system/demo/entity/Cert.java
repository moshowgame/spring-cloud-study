package com.softdev.system.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cert implements Serializable {
    Integer certId;
    String certNumber;
}
