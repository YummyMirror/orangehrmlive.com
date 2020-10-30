package com.orangehrmlive.locator.userManagement;

import org.openqa.selenium.By;

public enum SystemUserViewPageLocators {
    ALL_ROWS("//*[@id = 'resultTable']/tbody/tr"),
    ADD_BUTTON("//*[@id = 'btnAdd']");

    private String id;

    SystemUserViewPageLocators(String id) {
        this.id = id;
    }

    public By locator() {
        return By.xpath(this.id);
    }
}
