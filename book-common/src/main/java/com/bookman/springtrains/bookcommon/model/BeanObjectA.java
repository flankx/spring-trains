package com.bookman.springtrains.bookcommon.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanObjectA {

    @Autowired
    private BeanObjectB objectB;

    public void func() {
        System.out.println("A");
//        objectB.func();
    }

//    public void setObjectB(BeanObjectB objectB) {
//        this.objectB = objectB;
//    }
}
