package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deneme extends TestBase {
    @Test
    public void googleAlert(){
        driver.get("http://google.com");
        WebElement element = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
        driver.switchTo().alert().accept();
       //WebDriverWait wait = new WebDriverWait(driver,30);
        //WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pzGYBf")));
        //button.click();
    }

}
