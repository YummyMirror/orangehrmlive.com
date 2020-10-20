package com.orangehrmlive.service;

import com.orangehrmlive.base.BasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Lazy
@Scope(SCOPE_PROTOTYPE)
@Service
public class NavigatorService extends BasePage {
    public void mainPage() {
        super.open("https://opensource-demo.orangehrmlive.com/");
    }
}
