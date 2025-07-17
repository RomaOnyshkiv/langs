package org.roman.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String URL = "https://duckduckgo.com/";
    private final By searchField = By.name("q");
    private final By searchBtn = By.name("btnK");

    public HomePage openHomePage() {
        goToURL(URL);
        assertTrue(getPageTitle().contains("DuckDuckGo"),"Wrong page");
        return this;
    }

    public HomePage searchFor(String query) {
        enterText(searchField, query);
        hitEnter(searchField);
        return this;
    }




}
