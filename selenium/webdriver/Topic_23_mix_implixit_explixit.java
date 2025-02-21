package webdriver;

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

public class Topic_23_mix_implixit_explixit {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }




    @Test
    public void TC_01_Implixit_Wait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://facebook.com/");

        driver.findElement(By.xpath(""));

        // khi vao tim element thi no tim thay ngay
        // khong can cho het timeout
    }

    @Test
    public void TC_02_Not_Found_Implixit_Wait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://facebook.co/");

        // khi vao tim khong thay element
        //Polling moi nua s tim lai 1 lan
        // khi het timeout thi se danh fail testcase va throw exeption: NosuchElement
        //NosuchElement: Unable to locate element:
    }

    @Test
    public void TC_03_Explixit_Wait() {
    explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

    //explicitWait.until(ExpectedConditions.visibilityOfElementLocated());

    }
    @Test
    public void TC_04_Not_Found_Explixit_Wait() {
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        // khi vao tim element khong tim thay
        //Polling moi nua s tim lai 1 lan
        //Khi het timeout se danh fail testcase va throw exception: TimeoutException


        //explicitWait.until(ExpectedConditions.visibilityOfElementLocated());

    }

    @Test
    public void TC_05_Mix_Implixit_Explixit_Wait() {
        driver.get("http://facebook.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        // khi vao tim element khong tim thay
        //Polling moi nua s tim lai 1 lan
        //Khi het timeout se danh fail testcase va throw exception: TimeoutException

        driver.findElement(By.xpath(""));

          //explicitWait.until(ExpectedConditions.visibilityOfElementLocated());

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


//1h19








