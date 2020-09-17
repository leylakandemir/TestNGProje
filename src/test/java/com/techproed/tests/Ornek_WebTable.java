package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {

    public void giris() {

        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        WebElement user = driver.findElement(By.id("UserName"));
        user.sendKeys("manager2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void test(){
        giris();
        List<WebElement> satirsayisi =driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Tabloda "+satirsayisi.size()+"tane satir vardir");

        WebElement ucuncuSatir= driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(ucuncuSatir.getText());
    }

}
