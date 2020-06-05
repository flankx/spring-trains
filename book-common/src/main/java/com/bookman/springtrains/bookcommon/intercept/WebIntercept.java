package com.bookman.springtrains.bookcommon.intercept;

import com.bookman.springtrains.bookcommon.annotation.ControllerCheck;
import com.bookman.springtrains.bookcommon.config.RedisLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WebIntercept implements WebMvcConfigurer {

    @Autowired
    RedisLimit redisLimit;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new CustomInterceptor()).addPathPatterns("/**");
    }

    public class CustomInterceptor extends HandlerInterceptorAdapter{

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            if (redisLimit == null){
                throw new NullPointerException("redisLimit is null");
            }

            if (handler instanceof HandlerMethod){
                HandlerMethod method = (HandlerMethod) handler;
                ControllerCheck annotation = method.getMethodAnnotation(ControllerCheck.class);
                if (annotation == null){
                    return true;
                }

                if (redisLimit.checkIsLimit()){
                    response.sendError(annotation.code(), annotation.message());
                    return false;
                }

            }
            return true;
        }
    }

}
