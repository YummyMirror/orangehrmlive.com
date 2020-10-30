package com.orangehrmlive.page.userManagement;

import com.orangehrmlive.model.User;

public interface SaveSystemUserPage {
    void createUser(User user, boolean isValid);
}
