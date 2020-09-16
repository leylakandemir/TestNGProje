package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        //String baskaDosyaYolu = kullaniciDosyaYolu + "/pomkhuhk.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
        //boolean yokMu = Files.exists(Paths.get(baskaDosyaYolu));
        //Assert.assertFalse(yokMu);

    }

@Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
    WebElement button = driver.findElement(By.id("file-upload"));
    button.sendKeys("C:\\Users\\admin\\Desktop\\Automation Tester\\Selenium\\6.GÜN.pdf");
    WebElement yukle = driver.findElement(By.id("file-submit"));
    yukle.click();

    WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));

    Assert.assertTrue(fileUploadedYazisi.isDisplayed());


}

@Test
    public void dosyaDownload(){
        //System.out.println(System.getProperty("user.home"));
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement Link = driver.findElement(By.partialLinkText("luminoslogo.png"));
        Link.click();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    boolean varMi = Files.exists(Paths.get("C:\\Users\\admin\\Downloads\\luminoslogo.png"));
    Assert.assertTrue(varMi);
}


}
