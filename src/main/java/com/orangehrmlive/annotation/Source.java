package com.orangehrmlive.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface Source {
    enum Type {CSV, XML, JSON, EXCEL, WORD}

    String value() default "";

    Type type() default Type.JSON;
}
