package com.orangehrmlive.service.impl;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.base.BasePage;
import com.orangehrmlive.page.element.NavigationMenu;
import com.orangehrmlive.service.NavigatorService;
import org.springframework.beans.factory.annotation.Value;

@LazyService
public class NavigatorServiceImpl extends BasePage implements NavigatorService {
    @Value("${app.url}")
    private String applicationUrl;

    @LazyAutowired
    private NavigationMenu navigationMenu;

    @Override
    public void mainPage() {
        super.open(this.applicationUrl);
    }

    @Override
    public NavigationMenu getNavigationMenu() {
        return this.navigationMenu;
    }
}
