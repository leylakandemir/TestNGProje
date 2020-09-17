package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {
    @Test
    public void sagTiklama() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        //bir webelemente sag tiklamak
        //action class ile islem yaparsaniz her seferinde perform() yazmalisiniz
        actions.contextClick(element).perform();

    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement element = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    @Test
    public void hoverOver() {
        driver.get("http://www.amazon.com");
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @Test
    public void asagiYukari() {
        driver.get("http://www.amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.PAGE_UP).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_UP).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    @Test
    public void buyukKucukYazma() {
        driver.get("http:/google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));

        aramaKutusu.sendKeys(Keys.SHIFT+"merhaba nasilsiniz live channel");
        Actions actions = new Actions(driver);
        aramaKutusu.sendKeys(Keys.SHIFT + "ben leyla ");
        actions.keyUp(Keys.SHIFT).sendKeys("sen ").perform();
        actions.keyDown(Keys.SHIFT).sendKeys("kimsin ").perform();
    }

    @Test
    public void dragAndDrop() {
        driver.get("http:/google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        WebElement logo = driver.findElement(By.id("hplogo"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(logo, aramaKutusu).perform();
    }

        @Test
        public void deneme () {
            driver.get("http:/google.com");
            WebElement aramaKutusu2 = driver.findElement(By.name("q"));

            Actions action = new Actions(driver);
            action.keyDown(Keys.SHIFT)
                    .sendKeys("merhaba")
                    .keyUp(Keys.SHIFT)
                    .sendKeys(" nasilsiniz")
                    .perform();

        }
    }









