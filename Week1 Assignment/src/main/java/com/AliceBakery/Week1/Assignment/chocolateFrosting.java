package com.AliceBakery.Week1.Assignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env",havingValue = "chocolate")
public class chocolateFrosting implements frosting{

    @Override
    public String getFrostingType() {
        return "chocolate frosting";
    }
}
