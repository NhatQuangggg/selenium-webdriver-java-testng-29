package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Topic_24_fluent_wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;
    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_fluent_Wait() {

        driver.get("https://automationfc.github.io/dynamic-loading/");

        waitAndFindElement(By.xpath("//button[text()='Start']")).click();

        String helloText = waitAndFindElement(By.xpath("//div[@id='finish']/h4")).getText();

        Assert.assertEquals(helloText, "Hello World!");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    public WebElement waitAndFindElement(By locator) {
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        return  fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }
}

// Time - Default Polling time: 0.5s
       // fluentDriver.withTimeout(Duration.ofSeconds(10));

        // Time - Default Polling time 0.3s
      //  fluentDriver.withTimeout(Duration.ofMillis(300));

// Cho cho Hello word text hien thi trong vong 10s

// SETTING
/*    fluentDriver.withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(100))
        .ignoring(NoSuchElementException.class);

//CONDITION
    fluentDriver.until(new Function<WebDriver, Boolean>() {
    @Override
    public Boolean apply(WebDriver webDriver) {
        return driver.findElement(By.xpath("")).isDisplayed();
    }

}
    }*/

// Chào mấy ní, chúc mấy ní 1 ngày vuiiii




