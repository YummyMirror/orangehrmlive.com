package com.orangehrmlive.page.jobTitle.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.Page;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.model.JobTitle;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItem;
import com.orangehrmlive.page.element.navigationItem.NavigationMenuItemFactory;
import com.orangehrmlive.page.jobTitle.SaveJobTitlePage;

@Page
public class SaveJobTitlePageImpl extends BasePage implements SaveJobTitlePage {
    @LazyAutowired
    private NavigationMenuItem jobTitleComponent;

    @LazyAutowired
    private NavigationMenuItemFactory menuItemFactory;

    @Override
    public void createJobTitle(JobTitle jobTitle, boolean isValid) {
        this.jobTitleComponent = this.menuItemFactory.get("jobTitle");
        this.jobTitleComponent.create(jobTitle, isValid);
    }
}
