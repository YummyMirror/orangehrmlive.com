package com.orangehrmlive.base;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.service.AppManagerService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {
    @LazyAutowired
    protected AppManagerService app;

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.app.stop();
    }
}
