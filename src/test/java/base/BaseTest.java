package base;

import org.openqa.selenium.WebDriver;
import org.roman.drivers.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    private final DriverFactory factory = new DriverFactory();

    @BeforeTest
    public void setUp() {
        factory.createDriver("chrome");
        driver = factory.getDriver();

    }

    @AfterTest
    public void tearDown() {
        factory.quitDriver();
    }


}
