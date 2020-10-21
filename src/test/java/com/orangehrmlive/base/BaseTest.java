package com.orangehrmlive.base;

import com.orangehrmlive.annotation.LazyAutowired;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {
    @LazyAutowired
    private ApplicationContext context;

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.context.getBean(WebDriver.class).quit();
    }
}
