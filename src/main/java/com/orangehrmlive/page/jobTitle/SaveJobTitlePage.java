package com.orangehrmlive.page.jobTitle;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Page
public class SaveJobTitlePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(SaveJobTitlePage.class);

    public void populate(JobTitle jobTitle, boolean isValid) {
        super.input(By.id("jobTitle_jobTitle"), jobTitle.getTitle());
        super.input(By.id("jobTitle_jobDescription"), jobTitle.getDescription());
        super.attach(By.id("jobTitle_jobSpec"), jobTitle.getSpecification());
        super.input(By.id("jobTitle_note"), jobTitle.getNote());
        super.click(By.id("btnSave"));
        if (isValid) {
            super.wait.until(urlContains("viewJobTitleList"));
        } else {
            super.wait.until(visibilityOfElementLocated(By.id("btnSave")));
        }
    }
}
