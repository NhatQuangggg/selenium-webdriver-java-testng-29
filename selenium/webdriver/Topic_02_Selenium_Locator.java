/*
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register");
    }


    // TestNG: Order testcase theo Alphabet (0-9 A-Z)
    // First name textbox - HTML Code
    // HTML Element: <tagname attribute_name_1 = 'attribute_value' attribute_name_2= 'attribute_value'...>
    */
/*
    * <input type="text" data-val="true" data -val-required="First name is required." id="FirstName" name ="FirstName">
    *//*


    // C: Class
    // m: Menthod
    // I: Interface
    // E: Enum
    // R: Record
    // A: Annotation
    // f: Biến final
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("testname");
        System.out.println(driver.findElement(By.id("FirstName")));
        //driver.findElement(By.ByCssSelector("input[id='FirstName']")
    }
    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_Link() {
        driver.findElement(By.linkText("Sitemap"));
    }
// do chính xac cao th nó search theo gia trị tuyệt đối
    @Test
    public void TC_06_Partial_Link() {
        driver.findElement(By.partialLinkText("vendor account"));
    }
// Dộ chính xác không cao v nó search theo gi tr tương đối
    @Test
    public void TC_07_CSS() {
        // CSS với ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        //CSS voi Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
        //CSS voi Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        //CSS voi tagname
        driver.findElement(By.cssSelector("input"));
        //CSS voi link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));
        //CSS voi partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
        //driver.findElement(By.cssSelector("a[href$='addresses']"));
        //XPath voi ID, dac thùla2a khong cho viet tat giong css
    }

    @Test
    public void TC_08_XPath() {
            driver.findElement(By.xpath("//input[@id='FirstName']"));

            //XPath voi Class
            driver.findElement(By.xpath("//div[@class='page-title']"));

            //XPath voi Name
            driver.findElement(By.xpath("//input[@name='FirstName']"));
            //XPath voi tagname
            driver.findElement(By.xpath("//input"));
            //CSS voi link
            driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
            driver.findElement(By.xpath("//a[text()='Addresses']"));
            //XPath voi partial link
            driver.findElement(By.xpath("//a[contains(@href, 'addresses')]"));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
*/
