package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyConfiguration;
import com.orangehrmlive.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class WebDriverConfig {
    @Value("${fullscreen}")
    private Boolean fullscreen;

    @LazyAutowired
    private DriverFactory driverFactory;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        return this.getChrome();
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        return this.driverFactory.create("edge", fullscreen);
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "ie")
    public WebDriver internetExplorerDriver() {
        return this.driverFactory.create("ie", fullscreen);
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriverInMissingBean() {
        return this.getChrome();
    }

    private WebDriver getChrome() {
        return this.driverFactory.create("chrome", fullscreen);
    }
}
