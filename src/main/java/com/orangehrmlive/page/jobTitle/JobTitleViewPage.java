package com.orangehrmlive.page.jobTitle;

import com.orangehrmlive.model.JobTitle;

import java.util.Set;

public interface JobTitleViewPage {
    Set<JobTitle> getJobTitles();

    void clickAddButton();

    void openJobTitle(JobTitle jobTitle);

    void deleteJobTitle(JobTitle jobTitle);
}
