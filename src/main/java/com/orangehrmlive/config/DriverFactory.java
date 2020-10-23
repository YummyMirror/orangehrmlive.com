package com.orangehrmlive.config;

import com.orangehrmlive.annotation.LazyService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@LazyService
public class DriverFactory {
    private static final Map<String, Function<Boolean, WebDriver>> MAP = new HashMap<>();

    public DriverFactory() {
        MAP.put("chrome", CHROME_SUPPLIER);
        MAP.put("edge", EDGE_SUPPLIER);
        MAP.put("ie", IE_SUPPLIER);
    }

    private static final Function<Boolean, WebDriver> CHROME_SUPPLIER = (isMaximized) -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (isMaximized) {
            chromeOptions.addArguments("--start-maximized");
        }
        return new ChromeDriver(chromeOptions);
    };

    private static final Function<Boolean, WebDriver> EDGE_SUPPLIER = (isMaximized) -> {
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        if (isMaximized) {
            edgeDriver.manage().window().maximize();
        }
        return edgeDriver;
    };

    private static final Function<Boolean, WebDriver> IE_SUPPLIER = (isMaximized) -> {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        WebDriver ieDriver = new InternetExplorerDriver(ieOptions);
        if (isMaximized) {
            ieDriver.manage().window().maximize();
        }
        return ieDriver;
    };

    WebDriver create(String browser, boolean isMaximized) {
        return MAP.get(browser)
                  .apply(isMaximized);
    }
}
