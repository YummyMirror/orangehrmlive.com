package com.orangehrmlive.base;

import com.orangehrmlive.annotation.LazyAutowired;
import com.orangehrmlive.listener.ScreenShoter;
import com.orangehrmlive.service.AppManagerService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@SpringBootTest
@Listeners({ScreenShoter.class})
public class BaseTest extends AbstractTestNGSpringContextTests {
    @LazyAutowired
    protected AppManagerService app;

    @BeforeClass(alwaysRun = true)
    public void setAttribute(ITestContext context) {
        context.setAttribute("app", this.app);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.app.stop();
    }
}
