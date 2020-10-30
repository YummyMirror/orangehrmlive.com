package com.orangehrmlive.page.element.navigationItem.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.PageFragment;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.BaseMenuItem;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItem;
import com.orangehrmlive.page.userManagement.SystemUserViewPage;
import org.openqa.selenium.By;

import static com.orangehrmlive.locator.userManagement.SaveSystemUserPageLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@PageFragment
public class SystemUserComponent extends BasePage implements NavigationMenuItem {
    @LazyAutowired
    private SystemUserViewPage systemUserViewPage;

    @Override
    public void create(BaseMenuItem menuItem, boolean isValid) {
        assert menuItem != null;
        if (menuItem instanceof User) {
            User user = (User) menuItem;
            this.systemUserViewPage.clickAddButton();
            super.input(EMPLOYEE_NAME.locator(), user.getEmployeeName());
            super.input(USERNAME.locator(), user.getUsername());
            super.input(PASSWORD.locator(), user.getPassword());
            super.input(PASSWORD.locator(), user.getPassword());
            By saveButton = SAVE_BUTTON.locator();
            super.click(saveButton);
            if (isValid) {
                super.wait.condition(urlContains("viewSystemUsers"));
            } else {
                super.wait.condition(visibilityOfElementLocated(saveButton));
            }
        } else {
            throw new RuntimeException("Wrong menu item type '" + menuItem + "'");
        }
    }

    @Override
    public void update(BaseMenuItem menuItem, boolean isValid) {
        assert menuItem != null;
        //TODO
    }

    @Override
    public void delete(BaseMenuItem menuItem) {
        assert menuItem != null;
        //TODO
    }
}
