package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_8_DataProvider {
    WebDriver driver;

    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");


@BeforeClass
public void beforeClass() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test(dataProvider = "loginData")
public void TC_01_LoginToSystem(String username, String password)  {
    driver.get("http://live.techpanda.org/index.php/customer/account/login/");

    driver.findElement(emailTextbox).sendKeys(username);
    driver.findElement(passwordTextbox).sendKeys(password);
    driver.findElement(loginButton).click();
    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));


    driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
    driver.findElement(By.xpath("//a[text()='Log Out']")).click();
}

@DataProvider(name = "loginData")
public Object[][] UserAndPasswordData() {
    return new Object[][]{
            {"selenium_11_01@gmail.com", "111111"},
            {"selenium_11_02@gmail.com", "111111"},
            {"selenium_11_03@gmail.com", "111111"}};
}

@AfterClass
public void afterClass() {
    driver.quit();
}
}