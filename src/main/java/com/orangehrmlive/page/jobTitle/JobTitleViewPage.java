package com.orangehrmlive.page.jobTitle;

import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Page
public class JobTitleViewPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(JobTitleViewPage.class);

    public Set<JobTitle> getJobTitles() {
        Set<JobTitle> jobTitles = getAllRows().stream()
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
        return findAll(By.xpath("//*[@id = 'resultTable']/tbody/tr"));
    }
}
