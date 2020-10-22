package com.orangehrmlive.test;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.model.User;
import com.orangehrmlive.page.LoginPage;
import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;
import com.orangehrmlive.service.NavigatorService;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTitleTests extends BaseTest {
    @LazyAutowired
    private NavigatorService navigate;

    @LazyAutowired
    private LoginPage loginPage;

    @LazyAutowired
    private JobTitleViewPage jobTitleViewPage;

    @LazyAutowired
    private SaveJobTitlePage saveJobTitlePage;

    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        this.navigate.mainPage();
        this.loginPage.loginAs(new User().setUsername(this.username)
                                         .setPassword(this.password),
                true);
        this.navigate.getNavigationMenu().open("Admin", "Job", "Job Titles");
    }

    @Test
    public void createJobTitleTest() {
        JobTitle jobTitle = new JobTitle().setTitle("Test Job Title 4")
                                          .setDescription("Test Description")
                                          .setSpecification(new File(""));

        Set<JobTitle> jobTitlesBefore = this.jobTitleViewPage.getJobTitles();
        this.jobTitleViewPage.clickAddButton();
        this.saveJobTitlePage.populate(jobTitle, true);
        Set<JobTitle> jobTitlesAfter = this.jobTitleViewPage.getJobTitles();
        jobTitlesBefore.add(
                jobTitle.setId(jobTitlesAfter.stream()
                                             .max(Comparator.comparingInt(JobTitle::getId))
                                             .get()
                                             .getId())
        );

        assertThat("Collections are not equal", jobTitlesBefore, is(equalTo(jobTitlesAfter)));
    }
}
