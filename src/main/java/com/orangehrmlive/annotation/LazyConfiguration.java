package com.orangehrmlive.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Lazy
@Configuration
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface LazyConfiguration {
}
