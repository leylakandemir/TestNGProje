package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    public void giris() {

        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        WebElement user = driver.findElement(By.id("UserName"));
        user.sendKeys("manager2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void table(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement w:basliklar) {
            System.out.println(w.getText());
        }}

        @Test
        public void tumSatirlar(){
            giris();
            List<WebElement>listem = driver.findElements(By.xpath("//tbody/tr"));
            for (WebElement w:listem) {
                System.out.println(w.getText());
            }
        }
    @Test
    public void tumHucreler(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement>tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement w :tumHucreler) {
            System.out.println(w.getText());

        }

}
    @Test
    public void belirlibirsutunyazdirma(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement>dorduncuSutun = driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement w:dorduncuSutun) {
            System.out.println(w.getText());
        }

    }
@Test
public void calistir(){
        giris();
        hucreYazdir(3,5);
}
    public void hucreYazdir(int satir, int sutun){
        //tbody/tr[3]/td[2]
        String xpathdegeri = "//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement hucre = driver.findElement(By.xpath(xpathdegeri));
        System.out.println(hucre.getText());
    }




    }


