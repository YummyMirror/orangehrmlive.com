package com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.config;

import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation.LazyBean;
import com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

@LazyConfiguration
public class WebDriverWaitConfig {
    @Value("${timeout:30}")
    private long timeout;

    @LazyBean
    public WebDriverWait webDriverWait(final WebDriver driver) {
        return new WebDriverWait(driver, this.timeout);
    }
}
