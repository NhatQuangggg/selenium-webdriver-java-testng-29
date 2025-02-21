package javaTester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;



public class Topic_06_Condition_Excercise {
    WebDriver driver;

    @Test
    public void TC_01 () {
        int number = 10;
        if(number % 2 == 0) {
            System.out.println("Số:" + number + "là số chẵn");
        }
        else {
            System.out.println("Số:" + number + "là số lẽ");
        }
    }


    @Test
    public void TC_02() {
        int a = 10;
        int b = 12;
        if(a > b) {
            System.out.println("a lớn hơn b");
        }
        else {
            System.out.println("a nhỏ hơn b");
        }
    }
    @Test
    public void TC_03() {
        int d = 10;
        int e = 12;
        int f = 11;
        if(d > e && d > f) {
            System.out.println("d là số lớn nhất ");
        } else if (e > f) {
            System.out.println("e là số lớn nhất ");
        } else {
            System.out.println("f là số lớn nhất ");
        }
    }
}



