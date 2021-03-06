package com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Lazy
@Bean
@Scope("browser")
@Documented
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface ThreadScopeBean {
}
