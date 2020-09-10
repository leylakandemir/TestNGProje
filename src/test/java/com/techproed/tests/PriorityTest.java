package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTest {

    WebDriver driver;

    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void dropDownTest(){
        driver.get("http://amazon.com");
    }
    @Test(priority = 2)
    public void AramaTest(){
        driver.get("http://google.com");
    }
    @Test (priority = 3)
    public void Test(){
        driver.get("http://facebook.com");
    }
    @AfterClass
    public void tearDown(){

    }
}
