package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@LazyService
public class RemoteWebDriverFactory {
    private static final Map<String, Function<Boolean, WebDriver>> MAP = new HashMap<>();

    public RemoteWebDriverFactory() {
        MAP.put("chrome", CHROME_FUNCTION);
        MAP.put("firefox", FIREFOX_FUNCTION);
    }

    private static final Function<Boolean, WebDriver> CHROME_FUNCTION = (isMaximized) -> {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        WebDriver driver = initRemoteWebDriver(caps);
        maximizedBrowserIfNeeded(driver, isMaximized);
        return driver;
    };

    private static final Function<Boolean, WebDriver> FIREFOX_FUNCTION = (isMaximized) -> {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        WebDriver driver = initRemoteWebDriver(caps);
        maximizedBrowserIfNeeded(driver, isMaximized);
        return driver;
    };

    private static WebDriver initRemoteWebDriver(DesiredCapabilities caps) {
        WebDriver driver = null;
        try {
            String hubHost = System.getProperty("HUB_HOST");
            if (hubHost != null) {
                driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), caps);
            } else {
                driver = new RemoteWebDriver(new URL("http:/localhost:4444/wd/hub"), caps);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static void maximizedBrowserIfNeeded(WebDriver driver, boolean isMaximized) {
        if (isMaximized) {
            assert driver != null;
            driver.manage().window().maximize();
        }
    }

    public RemoteWebDriver create(String browser, boolean isMaximized) {
        return (RemoteWebDriver) MAP.get(browser).apply(isMaximized);
    }
}
