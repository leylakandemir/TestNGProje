package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi  extends TestBase {

    @Test
    public void Test01(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(element).perform();
        driver.findElement(By.linkText("Start here.")).click();
        String title =driver.getTitle();
        Assert.assertEquals(title,"Amazon Registration");

    }
    @Test (dependsOnMethods = "Test01")
    public void Test02() {

        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Leyla KANDEMIR");
        driver.findElement(By.id("ap_email")).sendKeys("leylakandemir00@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("L16220825K");

        driver.findElement(By.id("ap_password_check")).sendKeys("L16220825K");
        driver.findElement(By.id("continue")).submit();

    }


}
