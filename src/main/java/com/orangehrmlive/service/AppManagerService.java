package com.orangehrmlive.service;

import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import com.orangehrmlive.page.jobTitle.UpdateJobTitlePage;
import com.orangehrmlive.page.login.LoginPage;

import java.io.File;

public interface AppManagerService {
    void stop();

    File takeScreenshotAsFile();

    NavigatorService navigate();

    LoginPage loginPage();

    JobTitleViewPage jobTitleViewPage();

    SaveJobTitlePage saveJobTitlePage();

    UpdateJobTitlePage updateJobTitlePage();
}
