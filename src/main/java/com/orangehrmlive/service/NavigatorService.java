package com.orangehrmlive.service;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.page.element.NavigationMenu;
import org.springframework.beans.factory.annotation.Value;

@LazyService
public class NavigatorService extends BasePage {
    @Value("${app.url}")
    private String applicationUrl;

    @LazyAutowired
    private NavigationMenu navigationMenu;

    public void mainPage() {
        super.open(this.applicationUrl);
    }

    public NavigationMenu getNavigationMenu() {
        return this.navigationMenu;
    }
}
