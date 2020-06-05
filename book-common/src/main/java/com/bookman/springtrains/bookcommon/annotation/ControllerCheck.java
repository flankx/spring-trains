package com.bookman.springtrains.bookcommon.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerCheck {

    int code() default 500;

    String message() default "request has been limited";

}
