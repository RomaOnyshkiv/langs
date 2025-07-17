package org.roman.drivers;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;

    public void createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
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

    public WebDriver getDriver() {
        return driver;
    }


}
