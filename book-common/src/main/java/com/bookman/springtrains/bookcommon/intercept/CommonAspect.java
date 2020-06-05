package com.bookman.springtrains.bookcommon.intercept;


import com.bookman.springtrains.bookcommon.config.RedisLimit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CommonAspect {

    private final static Logger logger = LoggerFactory.getLogger(CommonAspect.class);

    @Autowired
    RedisLimit redisLimit;

    @Pointcut("@annotation(com.bookman.springtrains.bookcommon.annotation.CommonCheck)")
    public void check(){
    }

    @Before("check()")
    public void checkLimit(JoinPoint jp) throws Exception{
        logger.info("getKind = " + jp.getKind());
        logger.info("getArgs = " + Arrays.toString(jp.getArgs()));
        logger.info("getSignature = " + jp.getSignature());
        logger.info("getSourceLocation = " + jp.getSourceLocation());
        logger.info("getStaticPart = " + jp.getStaticPart());
        logger.info("getTarget = " + jp.getTarget());
        logger.info("getThis = " + jp.getThis());
        logger.info("getClass().getName = " + jp.getClass().getName());
        logger.info("toString = " + jp.toString());
        logger.info("toShortString = " + jp.toShortString());
        logger.info("toLongString = " + jp.toLongString());

        if (redisLimit == null){
            throw new NullPointerException("redisLimit is null");
        }

        if (redisLimit.checkIsLimit()){
            throw new RuntimeException("request has been limited");
        }
    }

}
