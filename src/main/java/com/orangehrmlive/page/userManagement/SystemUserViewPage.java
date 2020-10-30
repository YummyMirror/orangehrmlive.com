package com.orangehrmlive.page.userManagement;

import com.orangehrmlive.model.User;

import java.util.Set;

public interface SystemUserViewPage {
    Set<User> getUsers();

    void clickAddButton();

    void openUser(User user);

    void deleteUser(User user);
}
