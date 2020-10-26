package com.orangehrmlive.locator.auth;

import org.openqa.selenium.By;

public enum LoginPageLocators {
    USERNAME("//*[@id = 'txtUsername']"),
    PASSWORD("//*[@id = 'txtPassword']"),
    LOGIN_BUTTON("//*[@id = 'btnLogin']"),
    WELCOME_LABEL("//*[@id = 'welcome']");

    String xpath;

    LoginPageLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
