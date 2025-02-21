package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Topic_17_Window {
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
        driver.get("https://automationfc.github.io/basic-form/index.html");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // lay ra id cua window hien tai
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='https://google.com.vn']")).click();
        sleepInSeconds(3);

       switchtoWindowByID(parentID);

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Duong khung");
        sleepInSeconds(5);


        String googleID = driver.getWindowHandle();

       driver.findElement(By.xpath("//a[@href='https://facebook.com']")).click();
       sleepInSeconds(3);



        switchToWindowbyTitle("Facebook");
    }

    @Test
    public void TC_02_Window() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//li[@class='item last']//a[@class='product-image' and @title ='Xperia']/following-sibling::div//div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//li[@class='item last']//a[@class='product-image' and @title ='Samsung Galaxy']/following-sibling::div//div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Samsung Galaxy has been added to comparison list.");
        sleepInSeconds(1);

        driver.findElement(By.xpath("//span[text()='Compare']")).click();
        sleepInSeconds(3);

        switchToWindowbyTitle("Products Comparison List - Magento Commerce");
        driver.findElement(By.xpath("//span[text()='Close Window']")).click();
    }
    @Test
    public void TC_03_Window_Ver4() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//li[@class='item last']//a[@class='product-image' and @title ='Xperia']/following-sibling::div//div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//li[@class='item last']//a[@class='product-image' and @title ='Samsung Galaxy']/following-sibling::div//div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Samsung Galaxy has been added to comparison list.");
        sleepInSeconds(1);

        driver.findElement(By.xpath("//span[text()='Compare']")).click();
        sleepInSeconds(3);

        driver.switchTo().newWindow(WindowType.WINDOW).get("live.techpanda.org/index.php/catalog/product_compare/index/");
        sleepInSeconds(3);
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