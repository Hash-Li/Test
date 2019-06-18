package com.bulinbulin.test.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加自定义注解的原因是，方便管理哪些方法使用了重复点击的AOP，
 * 同时可以在注解中传入点击时间间隔，更加灵活。 @SingleClick(2000)
 * @author 12482
 * @date 2019/6/17 20:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleClick {
    /* 点击间隔时间 */
    long value() default 1500;
}
