package com.orangehrmlive.page.element.navigationItem.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.PageFragment;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.BaseMenuItem;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.element.ConfirmDialog;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItem;
import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import org.openqa.selenium.By;

import static com.orangehrmlive.locator.jobTitle.JobTitleViewPageLocators.DELETE_BUTTON;
import static com.orangehrmlive.locator.jobTitle.SaveJobTitlePageLocators.*;
import static com.orangehrmlive.locator.jobTitle.UpdateJobTitlePageLocators.SAVE_BUTTON;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@PageFragment
public class JobTitleComponent extends BasePage implements NavigationMenuItem {
    @LazyAutowired
    private JobTitleViewPage jobTitleViewPage;

    @LazyAutowired
    private SaveJobTitlePage saveJobTitlePage;

    @LazyAutowired
    private ConfirmDialog confirmDialog;

    @Override
    public void create(BaseMenuItem menuItem, boolean isValid) {
        assert menuItem != null;
        if (menuItem instanceof JobTitle) {
            JobTitle jobTitle = (JobTitle) menuItem;
            this.jobTitleViewPage.clickAddButton();
            super.input(TITLE.locator(), jobTitle.getTitle());
            super.input(DESCRIPTION.locator(), jobTitle.getDescription());
            super.input(NOTE.locator(), jobTitle.getNote());
            By saveButton = SAVE_BUTTON.locator();
            super.click(saveButton);
            if (isValid) {
                super.wait.condition(urlContains("viewJobTitleList"));
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
        if (menuItem instanceof JobTitle) {
            JobTitle jobTitle = (JobTitle) menuItem;
            By saveButton = SAVE_BUTTON.locator();
            super.click(saveButton);
            super.wait.condition(attributeToBe(saveButton, "value", "Save"));
            this.saveJobTitlePage.createJobTitle(jobTitle, isValid);
        } else {
            throw new RuntimeException("Wrong menu item type '" + menuItem + "'");
        }
    }

    @Override
    public void delete(BaseMenuItem menuItem) {
        assert menuItem != null;
        if (menuItem instanceof JobTitle) {
            JobTitle jobTitle = (JobTitle) menuItem;
            super.click(By.xpath("//input[@value = '" + jobTitle.getId() + "']"));
            super.click(DELETE_BUTTON.locator());
            this.confirmDialog.confirmAction();
        } else {
            throw new RuntimeException("Wrong menu item type '" + menuItem + "'");
        }
    }
}
