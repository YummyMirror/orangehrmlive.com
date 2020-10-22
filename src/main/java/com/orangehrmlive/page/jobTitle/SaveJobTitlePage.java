package com.orangehrmlive.page.jobTitle;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class SaveJobTitlePage extends BasePage {
    public void populate(JobTitle jobTitle, boolean isValid) {
        assert jobTitle != null;
        super.input(By.id("jobTitle_jobTitle"), jobTitle.getTitle());
        super.input(By.id("jobTitle_jobDescription"), jobTitle.getDescription());
        super.input(By.id("jobTitle_note"), jobTitle.getNote());
        super.click(By.id("btnSave"));
        if (isValid) {
            super.wait.until(urlContains("viewJobTitleList"));
        } else {
            super.wait.until(visibilityOfElementLocated(By.id("btnSave")));
        }
    }
}
