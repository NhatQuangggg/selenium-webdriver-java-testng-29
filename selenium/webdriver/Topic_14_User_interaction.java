package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_14_User_interaction {
    WebDriver driver;

    Actions actions;

    JavascriptExecutor javascriptExecutor;

    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // no se gia lap hanh vi cua chuot
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        javascriptExecutor = (JavascriptExecutor) driver;
    }


    @Test
    public void TC_01_Accept_Alert() {
    driver.get("https://automationfc.github.io/jquery-tooltip/");

    WebElement ageTextBox = driver.findElement(By.xpath("//input[@id='age']"));
    actions.moveToElement(ageTextBox).perform();
    sleepInSeconds(3);


    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(),"We ask for your age only for statistical purposes.");



    }

    @Test
    public void TC_02_Accept_Alert() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));

        Assert.assertEquals(allNumber.size(),20);

        // Chon theo block tu 00 --> 15
        actions.clickAndHold(allNumber.get(0))          // Click va giu gia tri 1
                .moveToElement(allNumber.get(14))       // di den gia tri 15
                .release()                              // tha chuot
                .perform();                             // thuc hien

        sleepInSeconds(3);

        List<String> allNuumberExpected = new ArrayList<String>();
        allNuumberExpected.add("1");
        allNuumberExpected.add("2");
        allNuumberExpected.add("3");
        allNuumberExpected.add("4");
        allNuumberExpected.add("5");
        allNuumberExpected.add("6");
        allNuumberExpected.add("7");
        allNuumberExpected.add("8");
        allNuumberExpected.add("9");
        allNuumberExpected.add("10");
        allNuumberExpected.add("11");
        allNuumberExpected.add("12");
        allNuumberExpected.add("13");
        allNuumberExpected.add("14");
        allNuumberExpected.add("15");

        // Tong cac element da chon
        List<WebElement> allNumberSelected = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
        Assert.assertEquals(allNumberSelected.size(),12);

        List<String> allNumberTextActual = new ArrayList<String>();

        for (WebElement element : allNumberSelected) {
            allNumberTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumberTextActual,allNumberTextActual);

    }

    @Test
    public void TC_03_ClickandHold() {
        driver.get("https://automationfc.github.io/jquery-selectable/ ");

        String osName = System.getProperty("os.name");
        Keys keys;

        if(osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }
        // cach 2
        //    Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND; // bieu thuc tam nguyen

        List<WebElement> allNumberValue = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
        // chon tu 1 --> 12
        actions.clickAndHold(allNumberValue.get(0)).moveToElement(allNumberValue.get(11)).release().perform();
        // nhan ctrl
        actions.keyDown(keys).perform();
        actions.clickAndHold(allNumberValue.get(12)).moveToElement(allNumberValue.get(14)).release().keyUp(keys).perform();
    }

    @Test
    public void TC_04_doubleClick() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));
        // scrollIntoView(true): keo element vao mep tren view port
        // scrollIntoView(false): keo xuong phia duoi cung cua view port ( van visible)
        if(driver.toString().contains("firefox")) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",doubleClick);
            sleepInSeconds(3);
        }
        actions.doubleClick(doubleClick).perform();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Hello Automation Guys!']")).getText(),"Hello Automation Guys!");

    }

    @Test
    public void TC_05_rightClick() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Paste']"))).click().perform();
        sleepInSeconds(3);
        // chuyen qua alert
        driver.switchTo().alert().accept();
        sleepInSeconds(3);

    }

    @Test
    public void TC_06_dragAndDropHTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        // source la vong tron nho
        // target la vong tron lon
        WebElement sourceCircles = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement targetCircles = driver.findElement(By.xpath("//div[@id='droptarget']"));

        actions.dragAndDrop(sourceCircles,targetCircles).perform();

        Assert.assertEquals(targetCircles.getText(),"You did great!");

        Assert.assertEquals(Color.fromString(targetCircles.getCssValue("background-color")).asHex().toLowerCase(),"#03a9f4");
    }

    @Test
    public void TC_07_dragAndDropHTML5() throws  IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        WebElement textboxA = driver.findElement(By.cssSelector("div#column-a"));
        WebElement textboxB = driver.findElement(By.cssSelector("div#column-b"));


        String projectPath = System.getProperty("user.dir");

        String dragAndDropFilePath = projectPath + "/dragAndDrop/drag_and_drop_helper.js";

        String jsContentFile = getContentFile(dragAndDropFilePath);

        // thuc thi doan lenhh js
        javascriptExecutor.executeScript(jsContentFile);
        sleepInSeconds(3);


    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = StandardCharsets.UTF_8;
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
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


// Ham su dung nhieu nhat la
//          scrollByAmount
//          scrollToElement     ---------- chu yeu
//          scrollfromOrgigin



//contextmenu: nghia la menu vao chuot phai
// build: ket hop 2 ham lai de thuc thi

// release(): chi dung duy nhat cho ham click&hold de nha chuot

//perform: dung cuoi cung de thuc thi toan bo cau lenh


// ngoai viec debugg ra bang F8
// Vao tab console ----- >   setTimeout(() => {debugger;}, 3000);


// click driver,find element khac click action o cho: click action can hover vao moi click dc


// so sanh text thi nen su dung (Assert.assertTrue....isDisplay)  de tranh TH chu hoa va chu thuong


// convet qua list :
// List <String> text = Array.aslist('');

// doi voi cau lenh moveToElement thi chi su dung cho engine Chromium thoi.