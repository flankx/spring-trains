package com.bookman.springtrains.sentrytest.controller;

import io.sentry.Sentry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
    @GetMapping("/exception")
    public void exception(){
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            Sentry.captureException(e);
        }

        logger.info("This is a info test");
        logger.warn("This is a warn test");
        logger.error("This is a error test");
        throw new RuntimeException("this a runtime exception test");
    }
}
