package testwithxmlparam;

import org.testng.annotations.Test;

import base.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.assertTrue;

public class TestWithXmlParam extends TestBase {
    @Test
    @Parameters({"year", "month", "day"})
    public void testStartDay(String year, String month, String day) {
        driver.findElement(By.id("txtStartDate_0")).sendKeys(month);
        driver.findElement(By.id("txtStartDate_1")).sendKeys(day);
        driver.findElement(By.id("txtStartDate_2")).click();
        driver.findElement(By.id("txtStartDate_2")).sendKeys(year);
        driver.findElement(By.id("txtPortfolio")).click();

        ExpectedCondition<Boolean> exp = d -> {
            return d.findElement(By.id("hintStartDate")).isDisplayed();
        };

        assertTrue((new WebDriverWait(driver, 10)).until(exp).booleanValue() == true);

    }
    @BeforeClass
    protected void setupTest() {
        super.setupTest();
        driver.get("http://students.bcitdev.com/A00950721/Lab08/application.html");
    }
  
    @AfterClass
    protected void clearupTest() {
        driver.close();
        super.clearupTest();
    }

}
