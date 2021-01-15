package com.bookman.springtrains.bookcommon.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanObjectB {

//    public void setObjectC(BeanObjectC objectC) {
//        this.objectC = objectC;
//    }

    @Autowired
    private BeanObjectC objectC;


    public void func() {
        System.out.println("B");
//        objectC.func();
    }
}
