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
import java.util.function.Supplier;

@LazyService
public class DriverFactory {
    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    public DriverFactory() {
        MAP.put("chrome", CHROME_SUPPLIER);
        MAP.put("edge", EDGE_SUPPLIER);
        MAP.put("ie", IE_SUPPLIER);
    }

    private static final Supplier<WebDriver> CHROME_SUPPLIER = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    };

    private static final Supplier<WebDriver> EDGE_SUPPLIER = () -> {
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    };

    private static final Supplier<WebDriver> IE_SUPPLIER = () -> {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        WebDriver ieDriver = new InternetExplorerDriver(ieOptions);
        ieDriver.manage().window().maximize();
        return ieDriver;
    };

    public WebDriver create(String browser) {
        return MAP.get(browser).get();
    }
}
