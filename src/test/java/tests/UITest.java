package tests;

import base.BaseTest;
import org.roman.pages.HomePage;
import org.testng.annotations.Test;

public class UITest extends BaseTest {

    @Test(groups = {"test"})
    public void testCheckUI(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage().searchFor("selenium");
    }
}
