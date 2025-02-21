package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class    Topic_22_explixit_2 {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    String projectPath = System.getProperty("user.dir");

    String conhuou = "conhuou.jpg";
    String conmeo = "conmeo.jpg";
    String hcm = "hcm.jpg";

    String conhuouFilePath = projectPath + File.separator + "picture" + File.separator + conhuou;
    String conmeoFilePath = projectPath + File.separator +"picture" + File.separator + conmeo;
    String hcmFilePath = projectPath + File.separator +"picture" + File.separator + hcm;


    @Test
    public void TC_01_Wait_find_element() {
    explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
    driver.get("https://automationfc.github.io/dynamic-loading/");

    // Wait cho element bien mat trong vong x giay
    explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");
    }
    //co 2 cach, cach 1 la invisible caielement do
    //           cach 2 lla  visible text phia sau

    @Test
    public void TC_02_Wait_find_element() {
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        driver.findElement(By.xpath("//a[text()='11']")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadAjaxLoadingPanel1ctl00_ContentPlaceholder1_RadCalendar1']/div[@class='raDiv']")));

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(),"Tuesday, June 11, 2024");
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


//1h19








