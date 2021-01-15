package com.bookman.springtrains.bookcommon.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanObjectC {

    @Autowired
    private BeanObjectA objectA;
//
//    public void setObjectA(BeanObjectA objectA) {
//        this.objectA = objectA;
//    }

    public void func() {
        System.out.println("C");
//        objectA.func();
    }
}
