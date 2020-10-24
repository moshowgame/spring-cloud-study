package com.softdev.system.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CertType implements Serializable {
    Integer typeId;
    String typeName;
    String certNumberPrefix;

    public CertType(Integer typeId, String typeName, String certNumberPrefix) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.certNumberPrefix = certNumberPrefix;
    }
}
