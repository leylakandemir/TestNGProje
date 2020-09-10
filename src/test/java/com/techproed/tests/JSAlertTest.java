package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        String msj = driver.switchTo().alert().getText();
        System.out.println(msj);
        driver.switchTo().alert().accept();


    }
    @Test
    public void jsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().dismiss();

    }
    @Test
    public void jsPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        driver.switchTo().alert().accept();

    }




}

