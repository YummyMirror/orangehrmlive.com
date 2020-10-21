package com.orangehrmlive.service;

import com.orangehrmlive.annotation.LazyService;
import com.orangehrmlive.base.BasePage;
import org.springframework.beans.factory.annotation.Value;

@LazyService
public class NavigatorService extends BasePage {
    @Value("${app.url}")
    private String applicationUrl;

    public void mainPage() {
        super.open(this.applicationUrl);
    }
}
