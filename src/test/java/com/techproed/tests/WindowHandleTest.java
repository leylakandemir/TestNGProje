package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninhandle = driver.getWindowHandle();
        System.out.println(sayfaninhandle);

        driver.findElement(By.linkText("Click Here")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Set <String> tumPencereler =driver.getWindowHandles();
        Object[] sekmeLlistem = (Object[])tumPencereler.toArray();
        String sayfaninhandle2 = sekmeLlistem[sekmeLlistem.length-1].toString();
        System.out.println(sayfaninhandle2);
        driver.switchTo().window(sayfaninhandle);


    }
}
