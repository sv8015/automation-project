package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class GoogleTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver("chrome");
    }

    @Test
    public void testGoogle() {
        DriverFactory.getDriver().get("https://www.google.com");
        System.out.println(DriverFactory.getDriver().getTitle());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
