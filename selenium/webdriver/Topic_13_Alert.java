package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Alert {
    WebDriver driver;

    WebDriverWait explicitWait;
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
        // chổ này thằng wait nó có 2 tham số
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Accept_Alert() {
// Loại này chỉ hiển thị và không cho mình cancel: alert("Accept alert") -- viết câu này trên tab console
    driver.get("https://automationfc.github.io/basic-form/index.html");

    driver.findElement(By.xpath("//div[@class='example']/button[@onclick ='jsAlert()']")).click();

    // chờ cho alert present
    // Nếu trong tg chờ mà xuất hiện thì tự switch vào
    // Nếu hết tg chờ mà chưa xuất hiện thì mới fail
    Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

    // Alert alert = driver.switchTo().alert(); ---> Để chuyển sang alert mới thgao tác dc


    Assert.assertEquals(alert.getText(),"I am a JS Alert");

    // Khi mình accpect r thì alert sẽ mất luôn
    alert.accept();
    sleepInSeconds(2);

    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']//p[text()='You clicked an alert successfully ']")).getText(),"You clicked an alert successfully");



    }


    @Test
    public void TC_02_Confirm_Alert() {
 // có 2 option để chọn: confirm ("Yes or no")
    driver.get("https://automationfc.github.io/basic-form/index.html");
    driver.findElement(By.xpath("//div[@class='example']/button[@onclick='jsConfirm()']")).click();

    Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

    Assert.assertEquals(alert.getText(),"I am a JS Confirm");

        // Khi mình accpect r thì alert sẽ mất luôn
        alert.accept();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']//p[text()='You clicked: Ok']")).getText(),"You clicked: Ok");



    }

    @Test
    public void TC_03_Promt_Alert() {


    }
    @Test
    public void TC_04_Authentication_Alert() {


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


// Alert khog inspect vào dc mà phải xài thư viện riêng

// Frame chính là 1 trang html khác nhưng có cùng domain với trang chính
// iFrame chính là 1 trang html khác nhưng KHÔNG cùng domain với trang chính


// Neu du an yeu cau lam chrome,ff,safari,edge thi dung ban selenium 4xx, con co opera thi xai 3xx


//Bai nay chua thuc hanh   ----------------------------------------