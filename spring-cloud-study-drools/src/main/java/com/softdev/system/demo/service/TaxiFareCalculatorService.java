package com.softdev.system.demo.service;

import java.math.BigDecimal;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdev.system.demo.entity.TaxiFare;
import com.softdev.system.demo.entity.TaxiRide;

@Service
public class TaxiFareCalculatorService {
    @Autowired
    private KieContainer kieContainer;

    public BigDecimal calculateFare(TaxiRide taxiRide, TaxiFare rideFare) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rideFare.total();
    }
}
