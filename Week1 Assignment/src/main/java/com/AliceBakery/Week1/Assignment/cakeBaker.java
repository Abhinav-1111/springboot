package com.AliceBakery.Week1.Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cakeBaker {

//    @Autowired
    private frosting frost;

//    @Autowired
    private syrup sip;

    public cakeBaker(frosting frost, syrup sip){
        this.frost = frost;
        this.sip = sip;
    }

    String bakeCake(){
        return frost.getFrostingType() + " and " +sip.getSyrupType();
    }
}
