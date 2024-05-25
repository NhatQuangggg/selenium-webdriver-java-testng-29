package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*public class Topic_01_Templa {
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void verifyTestNG() {
        // Trong java thư viện này để verify dữ liệu
        // Support cho cả Unit / Intergration / Automation test)

        // Mong muốn điều kiện trả về là dunng thì là assertTrue, ngược lại là assertFalse
        Assert.assertTrue();

        // Các hàm dữ liệu trả về giá trị boolean
        // Quy tắc: Bắt đầu với tiền tố là Isxxxx
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        //new.Select(driver.findElement(By.id(""))).isMultiple();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}*/

