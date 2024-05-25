package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class Topic_01_Data_Type {
    // Kiểu  liệu trong Java - 2 nhom

    // I - Kieu du liệu nguyên thuủy (Primitive Type)
    // 8 loại
    // So nguyen: byte, short, int , long
    byte bNumber = 40;

    short sNumber = 3000;

    int iNumber = 153423423;

    long  lNumber = 34345345;

    // So thuc: float - double
    float fNumber = 9.99f;
     double dNumber = 9.99d;
    // Co phan thap phan: diem so / luong...


    // Ki tu: char
    // Dai dien duy nhat 1 ki tu
    char c = 'M';


    // Logic: boolean
    boolean status = true;




    // II  - Kieu du lieu tham chieu (Reference Type)
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();

    // Interface
    WebDriver driver;

    // Object
    Object name = "Quang";

    // Array
    int[] tenbien = {15, 20, 4};
    String[] studentName = {"Auto test", "Testing"};

    // Collection: List /Set/Queue
    //List<String> studentAddress = new ArrayList<String>();

    // String - xCHuoi ki tu
    String fullname = "Le van Minh";

    // Khai bao 1 bien de luu tru 1 loai du lieu nao do
    // Access Modifier: Pham vi truy cap (public / private / protected / default)
    // Kieu du lieu
    // Ten bien
    // Gia tri cua bien
public int studentNumber = 200;


// 1h37

}
