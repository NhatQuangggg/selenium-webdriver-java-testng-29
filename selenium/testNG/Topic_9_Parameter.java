package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_9_Parameter {
    WebDriver driver;

    // trong TH mún dùng 1 tham số thì ("") còn nhiều thì xài mảng

@Parameters({"brower","Version"})

@BeforeClass
public void beforeClass(String browerName, String browerVersion) {
    driver = getBrowerDriver(browerName);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Parameters("environment")
@Test
public void TC_01_Login(String environmentName)  {
    driver.get(getEnvironmentName(environmentName) + "/index.php/customer/account/login/");

    driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
    driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
    driver.findElement(By.xpath("//*[@id='send2']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
}



private WebDriver getBrowerDriver (String browerName) {
    WebDriver driver;
    if(browerName.equals("firefox")) {
        driver = new FirefoxDriver();
    }   else if (browerName.equals("chrome")){
        driver = new ChromeDriver();
    }   else if(browerName.equals("edge")){
        driver = new EdgeDriver();
    }   else {
        throw new RuntimeException("Not found");
    }
    return driver;
}
 

    private WebDriver getEnvironmentName (String environmentName) {
        String urlValue;
        if(environmentName.equals("dev")) {
            urlValue = "http://dev.techpanda.org/";
        }   else if (environmentName.equals("stag")){
            urlValue = "http://stag.techpanda.org/";
        }   else if(environmentName.equals("production")){
            urlValue = "http://prod.techpanda.org/";
        }   else {
            throw new RuntimeException("Not found environment");
        }
        return driver;
    }


@AfterClass
public void afterClass() {
    driver.quit();
}
}