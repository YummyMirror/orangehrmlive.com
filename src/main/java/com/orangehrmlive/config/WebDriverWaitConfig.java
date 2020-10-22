package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyBean;
import com.orangehrmlive.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

@LazyConfiguration
public class WebDriverWaitConfig {
    @Value("${driver.timeout:30}")
    private long timeout;

    @LazyBean
    public WebDriverWait webDriverWait(final WebDriver driver) {
        return new WebDriverWait(driver, this.timeout);
    }
}
