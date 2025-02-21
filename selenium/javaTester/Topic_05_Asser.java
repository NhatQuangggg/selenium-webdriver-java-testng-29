package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_05_Asser {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() {
        // 8 loai locator
        // Id / name / Class = Attribute của HTML
        // LinkText / Partial Link text = The a cua HTML
        // Tagname: HTML tagname
        // Css/ Xpath

        // Selenium version 4x
        // Thêm Class - Relative Locator
        // above / bellow / near / leftOf / rightOf
    }

    @Test
    public void TC_02_() {
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
