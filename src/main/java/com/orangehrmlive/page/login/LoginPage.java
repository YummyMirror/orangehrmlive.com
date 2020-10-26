package com.orangehrmlive.page.login;

import com.orangehrmlive.model.User;

public interface LoginPage {
    void loginAs(User user, boolean isValid);

    boolean isUserLoggedIn();
}
