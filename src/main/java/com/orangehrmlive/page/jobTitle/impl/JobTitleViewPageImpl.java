package com.orangehrmlive.page.jobTitle.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItem;
import com.orangehrmlive.page.jobTitle.JobTitleViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.orangehrmlive.locator.jobTitle.JobTitleViewPageLocators.ADD_BUTTON;
import static com.orangehrmlive.locator.jobTitle.JobTitleViewPageLocators.TABLE_ROWS;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

@Page
public class JobTitleViewPageImpl extends BasePage implements JobTitleViewPage {
    private static final Logger logger = LoggerFactory.getLogger(JobTitleViewPageImpl.class);

    @LazyAutowired
    private NavigationMenuItem jobTitleComponent;

    @Override
    public Set<JobTitle> getJobTitles() {
        Set<JobTitle> jobTitles = this.getAllRows().stream()
                                      .map(row -> {
                                          List<WebElement> cells = row.findElements(By.xpath("./td"));
                                          return new JobTitle().setId(Integer.parseInt(cells.get(0).findElement(By.xpath("./input")).getAttribute("value")))
                                                               .setTitle(cells.get(1).findElement(By.xpath("./a")).getText())
                                                               .setDescription(cells.get(2).getText());
                                      })
                                      .collect(Collectors.toSet());
        logger.info("Collection of Job Titles is retrieved and equals '" + jobTitles.size() + "'");
        return jobTitles;
    }

    private List<WebElement> getAllRows() {
        return super.findAll(TABLE_ROWS.locator());
    }

    @Override
    public void clickAddButton() {
        super.click(ADD_BUTTON.locator());
        super.wait.condition(urlContains("saveJobTitle"));
    }

    @Override
    public void openJobTitle(JobTitle jobTitle) {
        assert jobTitle != null;
        super.click(By.xpath("//input[@value = '" + jobTitle.getId() + "']/..//following-sibling::td/a"));
        super.wait.condition(urlContains("saveJobTitle"));
        super.wait.condition(urlContains("jobTitleId=" + jobTitle.getId()));
    }

    @Override
    public void deleteJobTitle(JobTitle jobTitle) {
        this.jobTitleComponent.delete(jobTitle);
    }
}
