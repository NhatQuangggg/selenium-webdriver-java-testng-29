package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Wait_explixit {
    WebDriver driver;
    WebDriverWait explicitWait; // khai bao chuas khoi tao
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Khoi tao 1 explixit wait co tong thoi gian cho la 10s -polling la 0.5s \
         explicitWait =  new WebDriverWait(driver,Duration.ofSeconds(10));

        // Khoi tao 1 explicitwait co tong thoi gian cho la 10s - polling la 0.3s
        //explicitWait = (WebDriver) new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));
    }


   /* @Test
    public void TC_01_Wait_find_element() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        // cho cho 1 alert presence trong html /DOm  truoc khi thao tac len
        Alert alert= explicitWait.until(ExpectedConditions.alertIsPresent());
        //alert.sendKeys();

        // cho element khong con trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(""))));

        // cho cho element co trong DOM, khong quan tam co trnog UI hay kh
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        //Cho cho 1 list element co trong Dom
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //cho cho  1-n element được hien thi tren UI
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("")));

        //cho cho element dc phep click: Link / button / checkbox / radio ...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector()));

        // cho cho page hien tai co title mong doi
        explicitWait.until(ExpectedConditions.titleIs());

        //ket hop nhieu dieu kien wait
        explicitWait.until(ExpectedConditions.and(explicitWait.until(ExpectedConditions.titleIs(),explicitWait.until(ExpectedConditions.elementToBeClickable()));

        //cho cho 1 element co attribute chưứagia1a tri mong doi      ----- tuong doi
         explicitWait.until(ExpectedConditions.attributeContains(By.xpath(""),"test","test"));

         //tuong tu tren nhưng cho gia tri tuyet doi
        explicitWait.until(ExpectedConditions.attributeToBe());

        // cho cho element dc select thanh cong
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));

        // cho cho element dc chon
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(),true)));

        // cho cho element chua dc chon
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(),false ));

        // cho cho frame hoac iframe dc available hoac switch qua
        // Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt());
        driver.switchTo().frame()
        // Index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1);
        //By or element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("")));


        // cho cho 1 element bien mat khong hien thi tren UI
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(""));

        // cho cho 1 doan code JS tra ve gia tri
        explicitWait.until(ExpectedConditions.jsReturnsValue("");

        // cho 1 doan js code duoc thuc thi khong nem ra ngoai le nao
        // khong nem ra : true
        // co ngoai le: false
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("");


        // cho so luong element bang 1 con so co dinh
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(""),10);
         explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan());
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan());

        // cho cho window tab la bao nhieu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe());
        //
        explicitWait.until(ExpectedConditions.textToBe(By.xpath(""),""));
        //lay gia tri url tuyet doi
        explicitWait.until(ExpectedConditions.urlToBe();
        // lay gia tri url tuong doi
        explicitWait.until(ExpectedConditions.urlContains();
        explicitWait.until(ExpectedConditions.urlMatches("")   // tra ve kieu du liieu regex

        // cho cho 1 dieu kien ma  element nay bi update trang thai  - load lai html
        explicitWait.until(ExpectedConditions.refreshed()

    }*/


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}









