package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class Topic_19_Upload_file {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    String conhuou = "conhuou.jpg";
    String conmeo = "conmeo.jpg";
    String hcm = "hcm.jpg";

    String conhuouFilePath = projectPath + File.separator + "picture" + File.separator + conhuou;
    String conmeoFilePath = projectPath + File.separator +"picture" + File.separator + conmeo;
    String hcmFilePath = projectPath + File.separator +"picture" + File.separator + hcm;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Checkbox() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadby = By.xpath("//input[@type='file']");

        driver.findElement(uploadby).sendKeys(conhuouFilePath);
        driver.findElement(uploadby).sendKeys(conmeoFilePath);
        sleepInSeconds(4);

        //verify file load success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + conhuou + "']")).isDisplayed());
        // verify tuong doi gia tri con huou
    }



        @AfterClass
    public void afterClass() {
        driver.quit();
    }






// Neu co 2 tab/ windo thi nen su dung ID
    public void switchtoWindowByID(String expectedID) {
        // lay ra het tat ca cac tab
        Set<String>allIDs = driver.getWindowHandles();

        // dung vong lap duyet qua tung ID set o tren
        for(String id: allIDs) {
            if(!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    // Neu co >2 tab/ windo thi nen su dung Title.... vi title la duy nhat
    public void switchToWindowbyTitle(String expectedTitle) {
        // lay tat ca ID cua cac window/tab
        Set<String> allIDss = driver.getWindowHandles();

        // Dung vong lap de dueyt qua Set ID o tren
        for (String id : allIDss) {
            // cho switch vao tung ID truoc
            driver.switchTo().window(id);

            // lay ra title cua tab/window hien tai
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(String parentID) {
        Set<String>allIDs = driver.getWindowHandles();

        for (String id: allIDs) {
            if(!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
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