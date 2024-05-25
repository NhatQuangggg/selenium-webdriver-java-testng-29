/*
package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowers_Command {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được thì phải khởi tạo
        // Nếu không khởi tạo thì sẽ gặp lỗi: NullPointerExeption               //**
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();

        // Selenium ver 3/2/1
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);    // Deprecated

        // Selenium ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));         //**
    }
    @Test
    public void TC_01() {
           //Mở URL bất kì
          driver.get("test.com");                                                  //**

          // Dùng để lấy URL của màn hình hiện tại
          driver.getCurrentUrl();                                                  //*

          //Dùng để lấy ra page source của HTML/CSS/JS hiện tại
          // Verify 1 cách tương đối
          driver.getPageSource();
          driver.getCurrentUrl().contains("gfwertgfrwger");
          Assert.assertTrue(driver.getCurrentUrl().contains("gfwertgfrwger"));
          driver.get();

          // Dùng để đóng cái nó đang active ( nhiều hơn 1 thì nó đóng cái đang active)
          driver.close();                                                          //*
          // Đóng toàn bộ page
          driver.quit();                                                           //**
          // Lấy ra title cuas3 page hiện tại

          // 2 hàm này sẽ bị ảnh hưởng time out của implicitwait
          // findElement / findElements

          // Nó sẽ di tìm loại By nào và trả về element nếu như tìm thấy (webElement)
          // Ko dc tìm thấy: Fail tại step này - throw exception: NoSuchElementException
          WebElement emailAddressTextBox = driver.findElement(By.id("Email"));       // **


          // Nó sẽ di tìm với loại By  nào và trả về 1 danh sách element nếu như được tìm thấy (List Element)
          //  ko dc tìm thấy - ko bị fail - trả vế 1 list rỗng ( 0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));   //**

          driver.getTitle();
          // Lấy ra id của tab hiện tại
          driver.getWindowHandle();                                               //*
          // lấy ra hết toàn bộ
          driver.getWindowHandles();                                              //*

          // Câu lệnh in
        System.out.print();   // khonông có ln là không xuong dòng

        // CHo bài học về cookies
        driver.manage().getCookies();                                               //*
        // Get ra những log ở dev tool
        driver.manage().logs().get(LogType.DRIVER);                                //*
        // Apply cho việc tìm element/ elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));        //**

        // Chờ cho page dc load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // ít dùng
        // Set trước khi dùng với thư viện JavasccriptExecutor
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));


          // Sele ver 4 mới có các hàm sau
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();

        // Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();                                         //**
        driver.manage().window().minimize();

        // Set size / Giao diện
        driver.manage().window().setSize(new Dimension(1366, 768)); // test responsive

        // Set xong r thì sẽ có getsize
        driver.manage().window().getSize();

        //set cho browser ở vị trí nào so với độ phân giải của màn hình
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));


        // Alert / Window (Tab) / Frame (iFrame)                                    //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("test");


        // Handle Window / tab , sẽ dc học ở bài sau                                 //*
        // Đầu tiên phải lấy ra ID của cửa sổ hiện tại
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        driver.switchTo().frame(0);
        driver.switchTo().frame("test");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        // là frame trong di ra frame ngoài chứa nó
        driver.switchTo().parentFrame();







        // Các hàm sử dụng nhiều
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("test.com");
        driver.quit();
        WebElement emailAddressTextBox = driver.findElement(By.id("Email"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        driver.manage().window().maximize();



    }

    @Test
    public void TC_02_() {
        // Nếu chỉ dùng 1 lần thì không khai báo biến

        // Cách 1: Dành cho TH không khai báo
     Assert.assertEquals(driver.getCurrentUrl(), "http:testingvn.com" );
    }
        // Cách 2: Dành cho TH khai báo
    // String loginURL = driver.getCurrentUrl()
    //  khai báo           khởi tạo

        // Hàm là dùng dấu (), còn class là {}


   // Điều hướng trang web
        //WebDriver.Navigation
 

    //@AfterClass
    public void afterClass() {
        driver.quit();
    }
}
*/
