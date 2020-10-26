package com.orangehrmlive.page.jobTitle.impl;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class SaveJobTitlePageImpl extends BasePage implements SaveJobTitlePage {
    @Override
    public void populate(JobTitle jobTitle, boolean isValid) {
        assert jobTitle != null;
        super.input(By.id("jobTitle_jobTitle"), jobTitle.getTitle());
        super.input(By.id("jobTitle_jobDescription"), jobTitle.getDescription());
        super.input(By.id("jobTitle_note"), jobTitle.getNote());
        super.click(By.id("btnSave"));
        if (isValid) {
            super.wait.condition(urlContains("viewJobTitleList"));
        } else {
            super.wait.condition(visibilityOfElementLocated(By.id("btnSave")));
        }
    }
}
