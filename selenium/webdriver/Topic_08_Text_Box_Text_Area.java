package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Text_Box_Text_Area {
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
    public void TC_01_Empty_Email_and_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(1);

        // verify error messages
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
    }



    @Test
    public void TC_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("212121@2312431234");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(1);


        // verify error messages
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

    }


    @Test
    public void TC_03_Password_lower_than_6_characters() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);


        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");

        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(1);


        // verify error messages
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }


    @Test
    public void TC_04() {

    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.net";
    }
    @Test
    public void TC_05_Login_success() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

    // Khai baáo biến
        String fName ="Automation", lName="FC",emailAddress = getEmailAddress(), passWord ="Test1234!";
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(passWord);

        driver.findElement(By.xpath("//button[@title='Register']")).click();
        sleepInSeconds(2);

    // Khai báo biến cho text khi đăng nhập thành công
    String fullName = fName + ' ' + lName;

    //Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")),"Thank you for registering with Main Website Store.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']/p[1]")).getText(),"Hello, " + fullName + "!");

    String contactInfo = driver.findElement(By.xpath("//div[@class='box-title']/h3[text() ='Contact Information']//parent::div/following-sibling::div/p")).getText();
    Assert.assertTrue(contactInfo.contains(fName));
    Assert.assertTrue(contactInfo.contains(lName));

    //Logout
    driver.findElement(By.xpath("//a[@class='skip-link skip-account']/span[@class='label']")).click();
    sleepInSeconds(1);
    driver.findElement(By.xpath("//li[@class=' last']/a[@title='Log Out']")).click();
    sleepInSeconds(5);

    // login
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passWord);

    driver.findElement(By.xpath("//button[@id='send2']")).click();


    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']/p[1]")).getText(),"Hello, " + fullName + "!");

    contactInfo = driver.findElement(By.xpath("//div[@class='box-title']/h3[text() ='Contact Information']//parent::div/following-sibling::div/p")).getText();
    Assert.assertTrue(contactInfo.contains(fName));
    Assert.assertTrue(contactInfo.contains(lName));


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