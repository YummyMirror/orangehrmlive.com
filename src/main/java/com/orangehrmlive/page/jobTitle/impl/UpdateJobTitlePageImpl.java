package com.orangehrmlive.page.jobTitle.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import com.orangehrmlive.page.jobTitle.UpdateJobTitlePage;
import org.openqa.selenium.By;

import static com.orangehrmlive.locator.jobTitle.UpdateJobTitlePageLocators.SAVE_BUTTON;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;

@Page
public class UpdateJobTitlePageImpl extends BasePage implements UpdateJobTitlePage {
    @LazyAutowired
    private SaveJobTitlePage saveJobTitlePage;

    @Override
    public void updateJobTitle(JobTitle jobTitle, boolean isValid) {
        assert jobTitle != null;
        By saveButton = SAVE_BUTTON.locator();
        super.click(saveButton);
        super.wait.condition(attributeToBe(saveButton, "value", "Save"));
        this.saveJobTitlePage.populate(jobTitle, isValid);
    }
}
