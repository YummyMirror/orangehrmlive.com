package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyBean;
import com.orangehrmlive.annotation.LazyConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@LazyConfiguration
public class JavascriptExecutorConfig {
    @LazyBean
    public JavascriptExecutor js(final WebDriver driver) {
        return (JavascriptExecutor) driver;
    }
}
