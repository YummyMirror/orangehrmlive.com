package com.orangehrmlive.locator.element;

import org.openqa.selenium.By;

public enum ConfirmDialogLocators {
    CONFIRM_BUTTON("//input[id = 'dialogDeleteBtn']");

    String xpath;

    ConfirmDialogLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
