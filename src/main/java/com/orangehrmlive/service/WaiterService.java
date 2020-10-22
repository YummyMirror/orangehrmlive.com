package com.orangehrmlive.service;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@LazyService
public class WaiterService {
    @LazyAutowired
    private WebDriverWait wait;

    public <T> T condition(ExpectedCondition<T> condition) {
        return this.wait.until(condition);
    }

    public <T> T condition(ExpectedCondition<T> condition, String errMsg) {
        return this.wait.withMessage(errMsg)
                        .until(condition);
    }
}
