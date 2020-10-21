package com.orangehrmlive.test;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.LoginPage;
import com.orangehrmlive.page.element.NavigationMenu;
import com.orangehrmlive.service.NavigatorService;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.hamcrest.MatcherAssert.assertThat;

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



    @LazyAutowired
    private NavigationMenu navigationMenu;

    @Test
    public void loginTest() {
        this.loginPage.loginAs(
                new User().setUsername(this.username)
                          .setPassword(this.password),
                true
        );

        assertThat("User is NOT logged in", this.loginPage.isUserLoggedIn(), is(true));

        this.navigationMenu.open("tiMe", "pRoject info", "projects");
    }
}
