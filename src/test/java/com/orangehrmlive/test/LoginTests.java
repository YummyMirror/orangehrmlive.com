package com.orangehrmlive.test;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.LoginPage;
import com.orangehrmlive.service.NavigatorService;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @LazyAutowired
    private NavigatorService navigate;

    @LazyAutowired
    private LoginPage loginPage;

    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @BeforeClass(alwaysRun = true)
    public void openSite() {
        this.navigate.mainPage();
    }

    @Test
    public void loginTest() {
        this.loginPage.loginAs(
                new User().setUsername(this.username)
                          .setPassword(this.password),
                true
        );
    }
}
