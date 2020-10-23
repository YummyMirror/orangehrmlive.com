package com.orangehrmlive.service;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.page.LoginPage;
import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import com.orangehrmlive.page.jobTitle.UpdateJobTitlePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import java.io.File;

@LazyService
public class AppManagerService {
    @LazyAutowired
    private ApplicationContext context;

    @LazyAutowired
    private NavigatorService navigatorService;

    @LazyAutowired
    private LoginPage loginPage;

    @LazyAutowired
    private JobTitleViewPage jobTitleViewPage;

    @LazyAutowired
    private SaveJobTitlePage saveJobTitlePage;

    @LazyAutowired
    private UpdateJobTitlePage updateJobTitlePage;

    public void stop() {
        this.getDriver().quit();
    }

    public File takeScreenshotAsFile() {
        return ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);
    }

    private WebDriver getDriver() {
        return this.context.getBean(WebDriver.class);
    }

    public NavigatorService navigate() {
        return navigatorService;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public JobTitleViewPage jobTitleViewPage() {
        return jobTitleViewPage;
    }

    public SaveJobTitlePage saveJobTitlePage() {
        return saveJobTitlePage;
    }

    public UpdateJobTitlePage updateJobTitlePage() {
        return updateJobTitlePage;
    }
}
