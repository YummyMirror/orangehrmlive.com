package com.orangehrmlive.opensourcedemo.opensourcedemouiautomation.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
public class WebDriverConfig {
    @Lazy
    @Bean
    @Scope("browser")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    @Lazy
    @Bean
    @Scope("browser")
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    }

    @Lazy
    @Bean
    @Scope("browser")
    @ConditionalOnProperty(name = "browser", havingValue = "ie")
    public WebDriver internetExplorerDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        WebDriver ieDriver = new InternetExplorerDriver(ieOptions);
        ieDriver.manage().window().maximize();
        return ieDriver;
    }
}
