package com.orangehrmlive.listener;

import com.orangehrmlive.service.impl.AppManagerServiceImpl;
import org.apache.commons.io.FileUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShoter implements ITestListener {
    private static final String SCREENSHOT_PATH = "src/test/resources/screenshot/";

    @Override
    public void onTestFailure(ITestResult result) {
        this.saveScreenshot(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.saveScreenshot(result);
    }

    private void saveScreenshot(ITestResult result) {
        AppManagerServiceImpl app = (AppManagerServiceImpl) result.getTestContext().getAttribute("app");
        try {
            FileUtils.copyFile(app.takeScreenshotAsFile(), new File(SCREENSHOT_PATH + result.getMethod().getMethodName() +
                    "_" + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
