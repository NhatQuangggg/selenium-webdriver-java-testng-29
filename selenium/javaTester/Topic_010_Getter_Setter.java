package javaTester;

import  org.testng.annotations.Test;
public class Topic_010_Getter_Setter {

    private String fullName;


    @Test
    public void testGetterSetter() {
        setFullName("Automation testing");

        System.out.println(getFullName());

    }



    public String getFullName() {
        return fullName;
    }



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

// Thuong su dung getter & setter thi phai khai bao la PRIVATE