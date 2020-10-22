package com.orangehrmlive.page.jobTitle;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;

@Page
public class UpdateJobTitlePage extends BasePage {
    @LazyAutowired
    private SaveJobTitlePage saveJobTitlePage;

    public void updateJobTitle(JobTitle jobTitle, boolean isValid) {
        assert jobTitle != null;
        super.click(By.id("btnSave"));
        super.wait.condition(attributeToBe(By.id("btnSave"), "value", "Save"));
        this.saveJobTitlePage.populate(jobTitle, isValid);
    }
}
