package javaTester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_012_switchCase {
    WebDriver driver;
    @Test
    public void TC_01() {
    int month = 10;
    switch (month) {
        case 1:
        case 2:
        case 3:
            System.out.println("This month has 31 days");
            break;
        case 4:
            System.out.println("This month has 30 days");
            break;
        default:
            System.out.println("No days display on screen");
            break;
        }
    }
    public void TC_02(){
        int numberchoose = 10;
        switch (numberchoose) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
            case 4:
                System.out.println("four");
            case 5:
                System.out.println("five");
            case 6:
                System.out.println("six");
            case 7:
                System.out.println("seven");
            case 8:
                System.out.println("eight");
            case 9:
                System.out.println("nine");
        }
    }

}

//switchcase: dễ nhìn code hơn, check case trùng lặp dễ dàng hơn
//           - không xài break thì nó sẽ check hết ==> performance chậm
//	   - trong switch/case không sử dụng các toán tử dc nên tùy case mà áp dụng & chỉ nhận int, string/ enum
//if/else: