package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {
    public void girisTest() {

        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        WebElement user = driver.findElement(By.id("UserName"));
        user.sendKeys("manager2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
        @Test (groups = "fhctrip")
        public void test () {
            girisTest();
            driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
            FhcTripHotelCreatePage kayit =new FhcTripHotelCreatePage(driver);
            kayit.codeBox.sendKeys("1234");
            kayit.addressBox.sendKeys("Sumbul Cad.");
            kayit.mailBox.sendKeys("jhdkj@skfjdkls.com");
            kayit.nameBox.sendKeys("Techproed");
            kayit.phoneBox.sendKeys("2367890");
            kayit.idGroupBox.sendKeys("46809°");
            Select select= new Select(kayit.idGroupBox);
            select.selectByIndex(2);
            kayit.saveButton.click();

        }
    }

