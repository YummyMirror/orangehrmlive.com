package com.orangehrmlive.page.login.impl;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.login.LoginPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.orangehrmlive.locator.auth.LoginPageLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class LoginPageImpl extends BasePage implements LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPageImpl.class);

    @Override
    public void loginAs(User user, boolean isValid) {
        By username = USERNAME.locator();
        super.input(username, user.getUsername());
        super.input(PASSWORD.locator(), user.getPassword());
        super.click(LOGIN_BUTTON.locator());
        if (isValid) {
            super.wait.condition(visibilityOfElementLocated(getWelcomeLabelLocator()));
            logger.info("User '" + user.getUsername() + "' is logged in");
        } else {
            super.wait.condition(visibilityOfElementLocated(username));
            logger.info("User '" + user.getUsername() + "' is NOT logged in");
        }
    }

    public boolean isUserLoggedIn() {
        return super.isElementPresent(getWelcomeLabelLocator());
    }

    private By getWelcomeLabelLocator() {
        return WELCOME_LABEL.locator();
    }
}
