package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyConfiguration;
import com.orangehrmlive.annotation.ThreadScopeBean;
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

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriverInMissingBean() {
        return this.driverFactory.create("chrome");
    }
}
