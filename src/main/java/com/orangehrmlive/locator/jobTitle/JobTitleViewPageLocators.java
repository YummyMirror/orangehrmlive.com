package com.orangehrmlive.locator.jobTitle;

import org.openqa.selenium.By;

public enum JobTitleViewPageLocators {
    TABLE_ROWS("//*[@id = 'resultTable']/tbody/tr"),
    ADD_BUTTON("//*[@id = 'btnAdd']"),
    DELETE_BUTTON("//*[@id = 'btnDelete']");

    String xpath;

    JobTitleViewPageLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
