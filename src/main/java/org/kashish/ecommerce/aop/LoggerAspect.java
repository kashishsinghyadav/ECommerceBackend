package org.kashish.ecommerce.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerAspect {


    private  static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

//    @Before("execution(* *.*(..))")
    public void log() {
        LOGGER.info("logger info");
    }
}
