package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_011_Button {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Empty_Email_and_Password() {
    driver.get("https://egov.danang.gov.vn/reg");

    WebElement registerButton = driver.findElement(By.xpath("//input[@id='button2']"));

    //Verify button bị disable khi chưa click vào checkbox
    Assert.assertFalse(registerButton.isEnabled());

    //Verify button da dưđược enable sau khi click vào checkbox
    driver.findElement(By.xpath("//input[@id='chinhSach']")).click();
    sleepInSeconds(2);
    Assert.assertTrue(registerButton.isEnabled());

    // Lấy ra màu nền của button
    String getColorButtonRGB = registerButton.getCssValue("background-color");

    // Convert từ string RGB sang Hexa
    Color regiterBackGround = Color.fromString(getColorButtonRGB);

    //COnvert chuyển từ String RGb sang Hexa
    String regiterBackGroundHexa = regiterBackGround.asHex();

    Assert.assertEquals(regiterBackGroundHexa, "#ef5a00");
    }

    @Test
    public void TC_02_Empty_Email_and_Password() {
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.xpath("//ul[@id='popup-login-tab_list']/li[@class='popup-login-tab-item popup-login-tab-login']")).click();

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='fhs-btn-box']/button[@title='Đăng nhập']"));
        Assert.assertFalse(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");


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