package com.softdev.system.demo.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TaxiFare {
    private BigDecimal  nightSurcharge;
    private BigDecimal  rideFare;
    public BigDecimal  total() {
        return this.nightSurcharge.add(this.rideFare);
    }
}
