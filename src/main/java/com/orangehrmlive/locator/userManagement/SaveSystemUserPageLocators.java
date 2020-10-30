package com.orangehrmlive.locator.userManagement;

import org.openqa.selenium.By;

public enum SaveSystemUserPageLocators {
    EMPLOYEE_NAME("//*[@id = 'systemUser_employeeName_empName']"),
    USERNAME("//*[@id = 'systemUser_userName']"),
    PASSWORD("//*[@id = 'systemUser_password']"),
    SAVE_BUTTON("//*[@id = 'systemUser_confirmPassword']");

    private String id;

    SaveSystemUserPageLocators(String id) {
        this.id = id;
    }

    public By locator() {
        return By.xpath(this.id);
    }
}
