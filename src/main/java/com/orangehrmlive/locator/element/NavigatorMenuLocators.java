package com.orangehrmlive.locator.element;

import org.openqa.selenium.By;

public enum NavigatorMenuLocators {
    TOP_MENU_ITEMS("//li[contains(@class, 'main-menu-first-level-list-item')]/a"),
    CHILDREN_MENU_ITEMS(".//following-sibling::ul/li/a");

    String xpath;

    NavigatorMenuLocators(String xpath) {
        this.xpath = xpath;
    }

    public By locator() {
        return By.xpath(this.xpath);
    }
}
