package com.orangehrmlive.page.login.impl;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.login.LoginPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class LoginPageImpl extends BasePage implements LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPageImpl.class);
    private static final By USERNAME_LOCATOR = By.id("txtUsername");
    private static final By PASSWORD_LOCATOR = By.id("txtPassword");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("btnLogin");
    private static final By WELCOME_USERNAME_LOCATOR = By.id("welcome");

    @Override
    public void loginAs(User user, boolean isValid) {
        super.input(USERNAME_LOCATOR, user.getUsername());
        super.input(PASSWORD_LOCATOR, user.getPassword());
        super.click(LOGIN_BUTTON_LOCATOR);
        if (isValid) {
            super.wait.condition(visibilityOfElementLocated(WELCOME_USERNAME_LOCATOR));
            logger.info("User '" + user.getUsername() + "' is logged in");
        } else {
            super.wait.condition(visibilityOfElementLocated(USERNAME_LOCATOR));
            logger.info("User '" + user.getUsername() + "' is NOT logged in");
        }
    }

    public boolean isUserLoggedIn() {
        return super.isElementPresent(WELCOME_USERNAME_LOCATOR);
    }
}
