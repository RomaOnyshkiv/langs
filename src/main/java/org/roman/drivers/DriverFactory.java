package org.roman.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public void createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-dev-shm-usage", "--no-sandbox",
                        "--remote-allow-origins=*", "--disable-gpu", "--ignore-certificate-errors",
                        "window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException();
        }
        Duration duration = Duration.ofSeconds(60);
        driver.manage().timeouts()
                .implicitlyWait(duration)
                .scriptTimeout(duration)
                .pageLoadTimeout(duration);
    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}
