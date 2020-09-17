package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {

    @BeforeMethod
    public void girisTest(){

        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        WebElement user = driver.findElement(By.id("UserName"));
        user.sendKeys("manager2");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test
    public void hotelCreate() {

        driver.findElement(By.id("Code")).sendKeys("34567");
        driver.findElement(By.id("Name")).sendKeys("Etoile");
        driver.findElement(By.id("Address")).sendKeys("Muhlenbach");
        driver.findElement(By.id("Phone")).sendKeys("34567678999");
        driver.findElement(By.id("Email")).sendKeys("Etoile@gmail.com");

        Select select=new Select(driver.findElement(By.id("IDGroup")));
        select.selectByIndex(2);
        driver.findElement(By.id("btnSubmit")).submit();
        WebDriverWait wait = new WebDriverWait(driver,20);
        Boolean sonuc = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(sonuc);
    }

    }

