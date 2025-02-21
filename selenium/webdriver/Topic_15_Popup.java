package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_15_Popup {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_In_Dom() {                   // IN_DOM: Tuc la co hien thi element
       driver.get("https://ngoaingu24h.vn/");

       driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
       sleepInSeconds(5);

        // Kiem tra element co hien thi
        //Assert.assertEquals(driver.findElements(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//div[@class='modal-dialog'")).size(),0);

        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//input[@id='account-input' and @placeholder ='Tài khoản đăng nhập (*)']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//input[@id='password-input']")).sendKeys("Automationfc");
        sleepInSeconds(1);

        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//button[@class='btn-v1 btn-login-v1 buttonLoading']")).click();
        sleepInSeconds(1);

        //Verify text
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//div[@class='row error-login-panel']")).getText(),"Tài khoản không tồn tại!");

        // Click x de tat element
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style='display: block;']//button[@class='close']")).click();

        //Kiem tra element con hien thi hay khong ????

    }

    @Test
    public void TC_02_Fixed_Popup_In_Dom() {                   // IN_DOM: Tuc la co hien thi element
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        By test = By.xpath("//div[@id='k-popup-account-login-mb']//div[@class='modal-content']");

        Assert.assertTrue(driver.findElement(test).isDisplayed());

        driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//input[@id='user-login']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//input[@id='user-password']")).sendKeys("automationfc");
        sleepInSeconds(1);

        driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//button[@id='btn-submit-login']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//div[@class='t-text-error' and @id = 'password-form-login-message']")).getText(),"Sai tên đăng nhập hoặc mật khẩu");




    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_Dom() {                   // IN_DOM: Tuc la co hien thi element
        driver.get("https://tiki.vn/");

        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open' and @role = 'dialog']")).isDisplayed());

        driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open' and @role = 'dialog']//button[text()='Tiếp Tục']")).click();
        sleepInSeconds(2);
       // Verify
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open' and @role = 'dialog']//span[@class='error-mess']")).getText(),"Số điện thoại không được để trống");

        driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open' and @role = 'dialog']//img[@class='close-img']")).click();

        //Verify lan nua

        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open' and @role = 'dialog']")).size(),0);
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_Dom() {

    }

    @Test
    public void TC_06_Random_Not_In_Dom() {
    driver.get("https://vnk.edu.vn/");
    sleepInSeconds(20);
    if(driver.findElement(By.xpath("//div[@class='tcb-flex-row tcb-resized tcb--cols--2']")).isDisplayed()) {
        driver.findElement(By.xpath("//div[@class='thrv_wrapper thrv_icon tcb-icon-display tve_evt_manager_listen tve_et_click tve_ea_thrive_leads_form_close tcb-local-vars-root']")).click();
        sleepInSeconds(3);
        System.out.println("Popup hien thi");
    } else {
        System.out.println("Popup khong hien thi");
    }
    }

    @Test
    public void TC_07_Random_Not_In_Dom() {
        driver.get("https://dehieu.vn/");
        sleepInSeconds(3);
        if(driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']//input[@placeholder='Họ tên']")).sendKeys("Test");
            driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']//input[@placeholder='Email']")).sendKeys("test@gmail.com");
            driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']//input[@placeholder='Số điện thoại']")).sendKeys("0909449992");
            driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']//button[@id='submit-form']")).click();
            sleepInSeconds(3);
        } else {
            System.out.println("Popup khong hien thi");
        }
        if(driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']")).isDisplayed()){
            Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']//strong[text()='Bạn đã đăng ký thành công']")).getText(),"Bạn đã đăng ký thành công");
        } else{
            System.out.println("popup sau khong hien thi");
        }
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