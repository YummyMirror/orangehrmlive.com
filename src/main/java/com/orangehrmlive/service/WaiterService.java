package com.orangehrmlive.service;

import org.openqa.selenium.support.ui.ExpectedCondition;

public interface WaiterService {
    <T> T condition(ExpectedCondition<T> condition);

    <T> T condition(ExpectedCondition<T> condition, String errMsg);
}
