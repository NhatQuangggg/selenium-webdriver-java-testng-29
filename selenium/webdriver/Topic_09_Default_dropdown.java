package webdriver;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_09_Default_dropdown {
    WebDriver driver;

    String firstName = "KillerBee", lastName = "Tester", EmailAddress = getEmailAddress();
    String companyName ="Selenium", password = "123456";

    String day = "15", month = "November", year = "1950";

    public String getEmailAddress() {
        Random rand = new Random();
        return "KillerBee" + rand.nextInt(99999) + "@gmail.net";
    }


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Empty_Email_and_Password() {
    driver.get("https://demo.nopcommerce.com/register");
    driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    sleepInSeconds(1);


    // Cần verify là nó là single , option tổng là 32
    Select dayDropDown = new Select(driver.findElement(By.name("DateOfBirthDay")));
    // chọn ngày
    dayDropDown.selectByVisibleText(day);
    // verify singel ( kh phải mutiple)
    Assert.assertFalse(dayDropDown.isMultiple());
    // verify số lượng option
    Assert.assertEquals(dayDropDown.getOptions().size(),32);

    new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
    new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

    driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
    driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
    driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(EmailAddress);
    driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
    driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
    driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);

    driver.findElement(By.xpath("//button[@id='register-button']")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");


    }



    @Test
    public void TC_02_Invalid_Email() {
        driver.get("https://demo.nopcommerce.com/");
        //Login
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(EmailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        sleepInSeconds(3);

        //Verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("Automation"),"Automation");
        // so sánh giá trị ngày trả về
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);


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