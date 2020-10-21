package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyBean;
import com.orangehrmlive.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@LazyConfiguration
public class ActionsConfig {
    @LazyBean
    public Actions actions(final WebDriver driver) {
        return new Actions(driver);
    }
}
