package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_011_List {

    @Test
    public void testList() {
        List<String> studentName = new ArrayList<String>();
        studentName.add("Tester 1");
        studentName.add("Tester 2");
        studentName.add("Tester 3");

        //  3 element trong list
        System.out.println(studentName.size());

        System.out.println(studentName.get(0));

        System.out.println(studentName.get(studentName.size() - 1));
    }

}
