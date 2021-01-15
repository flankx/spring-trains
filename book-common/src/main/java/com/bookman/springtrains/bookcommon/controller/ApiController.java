package com.bookman.springtrains.bookcommon.controller;

import com.bookman.springtrains.bookcommon.annotation.ControllerCheck;
import com.bookman.springtrains.bookcommon.model.BeanObjectA;
import com.bookman.springtrains.bookcommon.model.BeanObjectB;
import com.bookman.springtrains.bookcommon.model.BeanObjectC;
import com.bookman.springtrains.bookcommon.util.TestTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    TestTool testTool;
    @Autowired
    BeanObjectA objectA;
    @Autowired
    BeanObjectB objectB;
    @Autowired
    BeanObjectC objectC;

    @GetMapping("/api")
    @ControllerCheck
    public Object hello(){
//        for (int i = 0; i < 10; i++) {
//            testTool.printHello("" + i);
//        }
//        objectA.setObjectB(objectB);
//        objectB.setObjectC(objectC);
//        objectC.setObjectA(objectA);

        objectA.func();
        objectB.func();
        objectC.func();
        return "success";
    }
}
