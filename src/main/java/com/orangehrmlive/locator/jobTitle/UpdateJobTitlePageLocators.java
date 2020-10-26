package com.orangehrmlive.locator.jobTitle;

import org.openqa.selenium.By;

public enum UpdateJobTitlePageLocators {
    SAVE_BUTTON("//*[@id = 'btnSave']");

    String xpath;

    UpdateJobTitlePageLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
