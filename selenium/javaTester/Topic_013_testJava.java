package javaTester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_013_testJava {
    WebDriver driver;
    String testData = "Automation FC";

    @Test
    public void TC_01() {
      char[] testdata2;
        testdata2 = testData.toCharArray();
        int cout = 0;
        for(char test: testdata2){
        if(test <= 'Z' && test >= 'A'){
            cout++;
        }
        }
        System.out.println("Sum of ...:" + cout);
    }

    @Test
    public void TC_02() {
        System.out.println(testData.length()
        );
    }
}

