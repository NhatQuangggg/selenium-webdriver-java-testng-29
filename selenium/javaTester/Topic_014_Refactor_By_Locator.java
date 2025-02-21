package javaTester;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Topic_014_Refactor_By_Locator {
    WebDriver driver;

    public static void main(String[] args) {
        String locatorValue = "xpath=//input[@id='name']";
        System.out.println(locatorValue);
        locatorValue = "Xpath=//input[@id='name']";
        System.out.println(locatorValue);
        locatorValue = "XPath=//input[@id='name']";
        System.out.println(locatorValue);
    }



    @Test
    public void TC_01_lower_Case() {
        String locatorValue = "Xpath=//input[@id='name']";
        Assert.assertEquals(getByLocator(locatorValue),By.xpath("//input[@id='name']"));
        driver.findElements(element)

    }
    public  By getByLocator(String locatorValue) {
        By by = null;
        if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("Xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")) {
            by = By.name(locatorValue.substring(5));
        } else if(locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")) {
            by = By.className(locatorValue.substring(6));
        } else if(locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TagName=") || locatorValue.startsWith("TAGNAME=")) {
            by = By.tagName(locatorValue.substring(8));
    } else {
            throw new RuntimeException("Locator type is not valid.");
        }
        return by;
    }


}

