package com.orangehrmlive.test;

import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTests extends BaseTest {
    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @BeforeClass(alwaysRun = true)
    public void openSite() {
        super.app.navigate().mainPage();
    }

    @Test
    public void validLoginTest() {
        super.app.loginPage().loginAs(
                new User().setUsername(this.username)
                          .setPassword(this.password),
                true
        );

        assertThat("User is NOT logged in", super.app.loginPage().isUserLoggedIn(), is(true));
    }
}
