package com.bookman.springtrains.bookcommon.util;

import com.bookman.springtrains.bookcommon.annotation.CommonCheck;
import org.springframework.stereotype.Component;

@Component
public class TestTool {

//    @CommonCheck
    public void printHello(String name){
        System.out.println("hello = " + name);
    }

}
