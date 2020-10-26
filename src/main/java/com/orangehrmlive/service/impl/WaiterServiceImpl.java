package com.orangehrmlive.service.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.service.WaiterService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@LazyService
public class WaiterServiceImpl implements WaiterService {
    @LazyAutowired
    private WebDriverWait wait;

    @Override
    public <T> T condition(ExpectedCondition<T> condition) {
        return this.wait.until(condition);
    }

    @Override
    public <T> T condition(ExpectedCondition<T> condition, String errMsg) {
        return this.wait.withMessage(errMsg)
                        .until(condition);
    }
}
