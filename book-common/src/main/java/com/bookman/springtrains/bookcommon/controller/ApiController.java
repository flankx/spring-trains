package com.bookman.springtrains.bookcommon.controller;

import com.bookman.springtrains.bookcommon.annotation.ControllerCheck;
import com.bookman.springtrains.bookcommon.util.TestTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    TestTool testTool;

    @GetMapping("/api")
    @ControllerCheck
    public Object hello(){
//        for (int i = 0; i < 10; i++) {
//            testTool.printHello("" + i);
//        }
        return "success";
    }
}
