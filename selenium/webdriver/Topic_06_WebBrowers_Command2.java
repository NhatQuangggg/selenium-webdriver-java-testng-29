/*
package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowers_Command2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Page_URL() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//li/a[@title='My Account']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    }
    @Test
    public void TC_02_Page_Title() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.getTitle(), "Customer Login");

    driver.findElement(By.xpath("//form//a[@title='Create an Account']")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
    @Test
    public void TC_03_Page_Navigation() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
    sleepInSeconds(3);

    driver.navigate().back();
    sleepInSeconds(3);

    Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/");
    sleepInSeconds(3);

    driver.navigate().forward();
    sleepInSeconds(3);

    Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
    @Test
    public void TC_04_Page_Source() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//form//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
         
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


*/
