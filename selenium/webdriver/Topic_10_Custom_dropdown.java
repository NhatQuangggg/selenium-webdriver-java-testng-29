package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
public class Topic_10_Custom_dropdown {
    WebDriver driver;

    // Wait tường minh: trạng thái cụ thể của element
    // Visible / Invisible / Presence /  Number / Clickable.... 
    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // đây là Wait ngầm định: Khoông rõ ràng cho 1 trạng thái cụ thể nào của element hết , ngầm định cho việc tìm elements,
        // Chỉ tìm thôi, hiển thị hay khoông thì không quan tâm.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Drop_down_list() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "10");


        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"10");

    }

    @Test
    public void TC_02_Drop_down_list() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropDown("//div[@id='root']","//div[@style='pointer-events:all']/span[@class='text']","Elliot Fu");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Elliot Fu");
        sleepInSeconds(3);

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropDown("//div[@id='root']","//div[@style='pointer-events:all']/span[@class='text']","Jenny Hess");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Jenny Hess");
    }

    @Test
    public void TC_03_Drop_down_list() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a","First Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"First Option");



    }
    @Test
    public void TC_04_Drop_down_list() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemEditInDropDown("//input[@class='search']","//div[@class='item']//span[@class='text']","Afghanistan");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Afghanistan");



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

    public void selectItemInDropDown(String parentXpath, String childItemXpath, String itemTextExpected) {
        driver.findElement(By.xpath(parentXpath)).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
        List<WebElement> allItems = driver.findElements(By.xpath(childItemXpath));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;

            }
        }
    }
    public void selectItemEditInDropDown(String parentXpath, String childItemXpath, String itemTextExpected) {
        driver.findElement(By.xpath(parentXpath)).clear();
        driver.findElement(By.xpath(parentXpath)).sendKeys(itemTextExpected);
        sleepInSeconds(1);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;

            }
        }
    }
}


//1h07





// refactor > rename là để thay thế toàn bộ chữ sang chữ khác