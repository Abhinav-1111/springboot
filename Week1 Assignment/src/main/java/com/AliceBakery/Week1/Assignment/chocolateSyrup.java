package com.AliceBakery.Week1.Assignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env",havingValue = "chocolate")
public class chocolateSyrup implements syrup {
    @Override
    public String getSyrupType() {
        return "chocolate syrup";
    }
}
