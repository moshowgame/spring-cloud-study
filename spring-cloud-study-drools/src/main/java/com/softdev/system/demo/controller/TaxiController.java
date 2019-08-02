package com.softdev.system.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.demo.entity.TaxiFare;
import com.softdev.system.demo.entity.TaxiRide;
import com.softdev.system.demo.service.TaxiFareCalculatorService;


@RequestMapping("taxi")
@RestController
/**
 * Drools的士计费控制器
 * (起步价：首3公里12元; 续租价：超过3公里部分，每公里2.6元;返空费实行阶梯附加，15至25公里按照续租价加收20%，25公里以上按续租价加收50%; )
 * @author zhengkai.blog.csdn.net
 * */
public class TaxiController {

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @GetMapping("cal")
    public ResponseEntity<Object> calTaxiFare(TaxiRide taxiRide){
        //http://localhost:9999/drools/taxi/cal
        if(taxiRide.getIsNightSurcharge()==null) {taxiRide.setIsNightSurcharge(false);}
        if(taxiRide.getDistanceInMile()==null) {taxiRide.setDistanceInMile(new BigDecimal(9));}
        TaxiFare rideFare = new TaxiFare();
        //Drools计算
        BigDecimal totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        //BigDecimal处理：设置一位小数位，向上取整，去掉末尾0，,转换为String
        String totalString = totalCharge.setScale(1,BigDecimal.ROUND_UP).stripTrailingZeros().toPlainString();
        return ResponseEntity.ok(totalString);
    }
}