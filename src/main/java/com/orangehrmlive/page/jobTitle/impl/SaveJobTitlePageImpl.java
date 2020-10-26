package com.orangehrmlive.page.jobTitle.impl;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import org.openqa.selenium.By;

import static com.orangehrmlive.locator.jobTitle.SaveJobTitlePageLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class SaveJobTitlePageImpl extends BasePage implements SaveJobTitlePage {
    @Override
    public void populate(JobTitle jobTitle, boolean isValid) {
        assert jobTitle != null;
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
    }
}
