package com.orangehrmlive.test;

import com.orangehrmlive.annotation.Source;
import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.dataProvider.DataProviders;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTitleTests extends BaseTest {
    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        this.app.navigate().mainPage();
        this.app.loginPage().loginAs(new User().setUsername(this.username).setPassword(this.password), true);
        this.app.navigate().getNavigationMenu().open("Admin", "Job", "Job Titles");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getJobTitles")
    @Source(value = "jobTitles.json")
    public void createJobTitleTest(JobTitle jobTitleForCreate) {
        Set<JobTitle> jobTitlesBefore = this.app.jobTitleViewPage().getJobTitles();
        this.app.jobTitleViewPage().clickAddButton();
        this.app.saveJobTitlePage().populate(jobTitleForCreate, true);
        Set<JobTitle> jobTitlesAfter = this.app.jobTitleViewPage().getJobTitles();
        jobTitlesBefore.add(
                jobTitleForCreate.setId(jobTitlesAfter.stream()
                                                      .max(Comparator.comparingInt(JobTitle::getId))
                                                      .get()
                                                      .getId())
        );

        assertThat("Collections are not equal", jobTitlesBefore, is(equalTo(jobTitlesAfter)));
    }

    @Test(priority = 1)
    public void updateJobTitleTest() {
        JobTitle jobTitleForUpdate = new JobTitle().setTitle("Test Job Title UPDATED 3")
                                                   .setDescription("Test Description UPDATED");

        Set<JobTitle> jobTitlesBefore = this.app.jobTitleViewPage().getJobTitles();
        JobTitle randomJobTitle = jobTitlesBefore.stream().findAny().get();
        this.app.jobTitleViewPage().openJobTitle(randomJobTitle);
        this.app.updateJobTitlePage().updateJobTitle(jobTitleForUpdate.setId(randomJobTitle.getId()), true);
        Set<JobTitle> jobTitlesAfter = this.app.jobTitleViewPage().getJobTitles();
        jobTitlesBefore.remove(randomJobTitle);
        jobTitlesBefore.add(jobTitleForUpdate);

        assertThat("Collections are not equal", jobTitlesBefore, is(equalTo(jobTitlesAfter)));
    }

    @Test(priority = 2)
    public void deleteJobTitleTest() {
        Set<JobTitle> jobTitlesBefore = this.app.jobTitleViewPage().getJobTitles();
        JobTitle randomJobTitle = jobTitlesBefore.stream().findAny().get();
        this.app.jobTitleViewPage().deleteJobTitle(randomJobTitle);
        Set<JobTitle> jobTitlesAfter = this.app.jobTitleViewPage().getJobTitles();
        jobTitlesBefore.remove(randomJobTitle);

        assertThat("Collections are not equal", jobTitlesBefore, is(equalTo(jobTitlesAfter)));
    }
}
