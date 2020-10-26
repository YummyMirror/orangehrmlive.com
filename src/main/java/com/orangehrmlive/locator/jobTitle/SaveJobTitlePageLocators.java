package com.orangehrmlive.locator.jobTitle;

import org.openqa.selenium.By;

public enum SaveJobTitlePageLocators {
    TITLE("//*[@id = 'jobTitle_jobTitle']"),
    DESCRIPTION("//*[@id = 'jobTitle_jobDescription']"),
    NOTE("//*[@id = 'jobTitle_note']"),
    SAVE_BUTTON("//*[@id = 'btnSave']");

    String xpath;

    SaveJobTitlePageLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
