package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Checkbox {
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
    public void TC_01_Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type = 'checkbox']"));

        // Chọn hết thì phải dùng vòng lặp
        for (WebElement checkBox : allCheckBoxes) {
            if (!checkBox.isSelected()) {
                checkBox.click();
                //sleepInSeconds(1);
            }
        }
        //Verify het tat cả checkbox cung phải dùng vòng lặp
        for(WebElement checkBox : allCheckBoxes) {
            Assert.assertTrue(checkBox.isSelected());

        }

        // CHọn 1 thằng trong tất cả
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckBoxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type = 'checkbox']"));

        for (WebElement checkBox: allCheckBoxes){
            if (checkBox.getAttribute("value").equals("Heart Attack") && !checkBox.isSelected()){
                checkBox.click(); 
                sleepInSeconds(1);
            }
        }
        // kiểm tra lại xem nó c ó selected hay chưa
        for (WebElement checkBox: allCheckBoxes){
            if(checkBox.getAttribute("value").equals("Heart Attack")){
                Assert.assertTrue(checkBox.isSelected());
            }
            else {
                Assert.assertFalse(checkBox.isSelected());
            }
        }
    }


    @Test
    public void TC_02_Radio_button() {
        driver.get("https://login.ubuntu.com/");

        By radio = By.xpath("//div[@class='hide-nojs user-intention']/input[@id='id_new_user']");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",driver.findElement(radio));
        sleepInSeconds(2);
        Assert.assertTrue(driver.findElement(radio).isSelected());
    }

    @Test
    public void TC_03_Radio_button() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By canThoRadio = By.xpath("//div[@aria-label ='Cần Thơ']");

        // verify radio is not selected
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"),"false");

        driver.findElement(canThoRadio).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"),"true");



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


// Đối với radio button thì thường nó sẽ bị ẩn bên dưới và mình chỉ có thể là click baằng cái bên ngoài và verify bằng cái bên trong bị ẩn
   // CLick vào thẻ div và vefiry bằng thẻ input ( thẻ naày mới là cái radio nên mới click dc coòn caái bên ngoài thì ko)
// Nhưng mình nên sử dụng JS để chọn luôn (JS không phân biệt nó có bị ẩn hay không )


// Interface thì không có NEW dc


// Hien thị (default) : thì nó là input  (Checkbox)