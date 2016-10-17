package base;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestBase {
    protected WebDriver driver;
    
    @BeforeClass
    protected void setupTest() {
        System.setProperty("webdriver.gecko.driver", "d:\\dev\\WebDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass
    protected void clearupTest() {
        driver.quit();
    }

}
