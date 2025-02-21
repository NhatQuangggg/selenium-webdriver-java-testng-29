package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_16_Shadow_DOM {
    WebDriver driver;




    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Iframe() {
       driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
       driver.findElement(By.xpath("//img[@src='https://www.formsite.com/wp-content/uploads/2023/05/Campus-Safety-Survey-Forms-and-Examples.png']")).click();
       sleepInSeconds(5);

       WebElement formIframe = driver.findElement(By.xpath("//div[@id='formTemplateContainer']/iframe"));
       Assert.assertTrue(formIframe.isDisplayed());

       // switch vao trang B
       driver.switchTo().frame(formIframe);
       new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-2']"))).selectByVisibleText("Sophomore");

       sleepInSeconds(2);

       //switch vao trang A lai
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//nav[@class='header header--desktop header--desktop-floater js-header js-active']//a[@class='fs-btn fs-btn--transparent-kashmir pull-right menu-item-login menu-item menu-item-type-custom menu-item-object-custom menu-item-26']")).click();

        sleepInSeconds(3);

        driver.findElement(By.xpath("//div[@class='auth-form__group']/button[@id='login']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='message-error']")).getText(),"Username and password are both required.");


    }


    @Test
    public void TC_02_Iframe_2() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        




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




// refactor > rename là để thay thế toàn bộ chữ sang chữ khác