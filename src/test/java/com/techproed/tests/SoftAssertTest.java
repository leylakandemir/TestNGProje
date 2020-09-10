package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*SoftAssert kullaniminin Hard Assert kullanimindan farki
            SoftAssert te eger test basarisizsa kalan kismi da calistiriyoruz
            SoftAssert classindan nesne olusturmak zorundayiz*/

WebDriver driver;
    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);

        softAssert.assertAll();
    }
        @Test
        public void test2(){
            driver.get("http://a.testaddressbook.com/sign_in");
            SoftAssert softAssert=new SoftAssert();

            WebElement email = driver.findElement(By.id("session_email"));
            email.sendKeys("testtechproed@gmail.com");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            softAssert.assertFalse(driver.getTitle().equals("Deneme"));


            WebElement sifre = driver.findElement(By.id("session_password"));
            sifre.sendKeys("Test1234!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            softAssert.assertFalse(driver.getTitle().equals("Address book"));

            WebElement submit = driver.findElement(By.name("commit"));
            submit.submit();

            WebElement signOut = driver.findElement(By.partialLinkText("Sign out"));
            boolean gorunuyorMu = signOut.isDisplayed();
            softAssert.assertTrue(gorunuyorMu);
            softAssert.assertAll();
        }

    }


