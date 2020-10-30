package com.orangehrmlive.service.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import com.orangehrmlive.page.jobTitle.UpdateJobTitlePage;
import com.orangehrmlive.page.login.LoginPage;
import com.orangehrmlive.page.userManagement.SaveSystemUserPage;
import com.orangehrmlive.page.userManagement.SystemUserViewPage;
import com.orangehrmlive.service.AppManagerService;
import com.orangehrmlive.service.NavigatorService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import java.io.File;

@LazyService
public class AppManagerServiceImpl implements AppManagerService {
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

    @LazyAutowired
    private SystemUserViewPage systemUserViewPage;

    @LazyAutowired
    private SaveSystemUserPage saveSystemUserPage;

    @Override
    public void stop() {
        this.getDriver().quit();
    }

    @Override
    public File takeScreenshotAsFile() {
        return ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);
    }

    private WebDriver getDriver() {
        return this.context.getBean(WebDriver.class);
    }

    @Override
    public NavigatorService navigate() {
        return navigatorService;
    }

    @Override
    public LoginPage loginPage() {
        return loginPage;
    }

    public JobTitleViewPage jobTitleViewPage() {
        return jobTitleViewPage;
    }

    @Override
    public SaveJobTitlePage saveJobTitlePage() {
        return saveJobTitlePage;
    }

    @Override
    public UpdateJobTitlePage updateJobTitlePage() {
        return updateJobTitlePage;
    }

    @Override
    public SystemUserViewPage systemUserViewPage() {
        return systemUserViewPage;
    }

    @Override
    public SaveSystemUserPage saveSystemUserPage() {
        return saveSystemUserPage;
    }
}
