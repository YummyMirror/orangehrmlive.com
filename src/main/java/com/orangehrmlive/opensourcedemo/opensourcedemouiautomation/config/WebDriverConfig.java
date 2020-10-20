package com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.config;

import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation.LazyAutowired;
import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation.LazyConfiguration;
import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation.ThreadScopeBean;
import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.application.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class WebDriverConfig {
    @LazyAutowired
    private DriverFactory driverFactory;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        return this.driverFactory.create("chrome");
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        return this.driverFactory.create("edge");
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "ie")
    public WebDriver internetExplorerDriver() {
        return this.driverFactory.create("ie");
    }
}
