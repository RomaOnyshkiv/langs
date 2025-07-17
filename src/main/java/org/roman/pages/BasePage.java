package org.roman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class BasePage {

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    private WebElement getElement(By by) {
        WebElement element = driver.findElement(by);
        assertTrue(element.isDisplayed());
        return driver.findElement(by);
    }

    protected void clickOn(By by) {
        this.getElement(by).click();
    }

    protected void hitEnter(By by) {
        this.getElement(by).sendKeys(Keys.ENTER);
    }

    protected void enterText(By by, String text) {
        this.getElement(by).sendKeys(text);
    }

    protected void goToURL(String url) {
        driver.get(url);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

}
