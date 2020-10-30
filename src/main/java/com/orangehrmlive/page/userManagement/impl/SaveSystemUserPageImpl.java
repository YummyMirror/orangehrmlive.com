package com.orangehrmlive.page.userManagement.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItem;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItemFactory;
import com.orangehrmlive.page.userManagement.SaveSystemUserPage;

public class SaveSystemUserPageImpl extends BasePage implements SaveSystemUserPage {
    @LazyAutowired
    private NavigationMenuItem systemUserComponent;

    @LazyAutowired
    private NavigationMenuItemFactory menuItemFactory;

    @Override
    public void createUser(User user, boolean isValid) {
        this.systemUserComponent = this.menuItemFactory.get("systemUser");
        this.systemUserComponent.create(user, isValid);
    }
}
