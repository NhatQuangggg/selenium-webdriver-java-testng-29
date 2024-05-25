package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Command {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //If (TH ở đây là nhập dữ liệu vào thì .sendKeys, còn nếu là radio button thì là .click();
        if (driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("automation testdata");
            System.out.println("Email TextBox is Displayed");
        } else {
            System.out.println("Email TextBox is not Displayed");
        }


        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());

    }

    @Test
    public void TC_02_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.xpath("//input[@id='mail']")).isEnabled()) {
            System.out.println("Email is enable");
        } else {
            System.out.println("Email is not enable");
        }


        if (driver.findElement(By.xpath("//input[@id='disable_password']")).isEnabled()) {
            System.out.println("Textbox is enable");
        } else {
            System.out.println("Textbox is Disable");
        }

        // Di chuyển dòng code: Alt + Mũi tên lên / xuống

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled()) {
            driver.findElement(By.xpath("//input[@id='under_18']")).click();
            System.out.println("Radio button is enable");
        } else {
            System.out.println("Radio button is not enable");

        }
    }


    @Test
    public void TC_03_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());

        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        sleepInSeconds(2);

        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
    }
// Case này báo sai là vì cái radio button đó chọn 2 lần đều là trạng thái selection, phải sửa thành checkbox thì mới đúng


    @Test
    public void TC_04_Displayed() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Quangtester@gmail.com");

        // Case 1: Nhaập number
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("12345");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());


        // Case 2: Lower text
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("text");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());



        // Case 3: Upper
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("TEXT");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());



        // Case 4: Special characters
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("$#@#@");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());



        // Case 5: 8 characters
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("123455678");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());


        // Case 6: Valid
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Test1234!");

        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
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