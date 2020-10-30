package com.orangehrmlive.test;

import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class SystemUserTests extends BaseTest {
    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        super.app.navigate().mainPage();
        super.app.loginPage().loginAs(super.getUser(), true);
        super.app.navigate().getNavigationMenu().open("Admin", "User Management", "Users");
    }

    @Test
    public void createSystemUserTest() {
        User userForCreate = new User().setUsername("Test_User").setUsername("Test_Username").setPassword("111");

        Set<User> usersBefore = super.app.systemUserViewPage().getUsers();
        super.app.saveSystemUserPage().createUser(userForCreate, true);
        Set<User> usersAfter = super.app.systemUserViewPage().getUsers();
        usersBefore.add(
                userForCreate.setId(usersAfter.stream()
                                              .max(Comparator.comparingInt(User::getId))
                                              .get()
                                              .getId())
        );

        assertThat("Collections are not equal", usersBefore, is(equalTo(usersAfter)));
    }
}
