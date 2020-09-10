package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    private void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba ben leyla");

    }
    @Test
    private void Test2(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement yazi = driver.findElement(By.xpath("//p"));
                yazi.clear();
                yazi.sendKeys("Merhaba iframe");

    }
    @Test
    private void Test3(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement yazi = driver.findElement(By.xpath("//p"));
        yazi.clear();
        yazi.sendKeys("Merhaba iframe");

    }
    @Test
    private void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba ben leyla");
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
        link.click();

    }







}
