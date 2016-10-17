package starter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestSearchGoogle {
    WebDriver driver;
    @Test
    public void testSearchGoogle() {
        driver.get("http://www.google.com");
        WebElement e = driver.findElement(By.name("q"));
        e.sendKeys("Selenium");
        e.submit();
        ExpectedCondition<Boolean> exp = d -> {
            return d.getTitle().toLowerCase().startsWith("selenium"); 
        };

        (new WebDriverWait(driver, 10)).until(exp);
    }
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "d:\\dev\\WebDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

  
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
