package com.softdev.system.demo.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TaxiRide {
    private Boolean isNightSurcharge;
    private BigDecimal distanceInMile;
}
