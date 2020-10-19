package com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Lazy
@Autowired
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface LazyAutowired {
}
