package com.orangehrmlive.base;

import com.orangehrmlive.annotation.LazyAutowired;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected Actions actions;

    protected void open(String url) {
        if (url != null && !url.isEmpty()) {
            if (!this.getCurrentUrl().equalsIgnoreCase(url)) {
                this.driver.navigate().to(url);
                this.wait.until(urlContains(url));
                logger.info("URL '" + url + "' is opened");
            } else {
                logger.info("Current URL '" + this.getCurrentUrl() + "' equals to the requested URL '" + url + "'");
            }
        } else {
            logger.error("URL '" + url + "' is either NULL or EMPTY");
        }
    }

    private String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    protected void input(By locator, String value) {
        if (value != null && !value.isEmpty()) {
            WebElement element = this.driver.findElement(locator);
            String currentValue = element.getAttribute("value");
            if (!currentValue.equalsIgnoreCase(value)) {
                element.click();
                element.clear();
                element.sendKeys(value);
                logger.info("Value '" + value + "' is entered");
            } else {
                logger.info("Current value '" + currentValue + "' equals to value for input '" + value + "'");
            }
        } else {
            logger.error("Value '" + value + "' is either NULL or EMPTY");
        }
    }

    protected void click(By locator) {
        this.wait.until(elementToBeClickable(locator)).click();
        logger.info("Element with locator '" + locator + "' is clicked");
    }

    protected void click(WebElement element) {
        this.wait.until(elementToBeClickable(element)).click();
    }

    protected WebElement find(By locator) {
        return this.driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return this.driver.findElements(locator);
    }

    protected boolean isElementPresent(By locator) {
        return this.driver.findElements(locator).size() > 0;
    }

    protected void moveToElement(WebElement element) {
        this.actions.moveToElement(element)
                    .build()
                    .perform();
    }
}
