package com.AliceBakery.Week1.Assignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = "strawberry")
public class strawberrySyrup implements syrup {
    @Override
    public String getSyrupType() {
        return "strawberry syrup";
    }
}
