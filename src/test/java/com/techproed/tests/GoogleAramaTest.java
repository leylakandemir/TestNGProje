package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleAramaTest extends TestBaseFinal {

    @Test
    public void aramaTest() throws InterruptedException {

        extentTest= extentReports.createTest("Google Arama, Google'da techproeducation aramasi yaptik");
        extentTest.info("webelementleri kullanabilmek icin nesne olustur");
    extentTest.info("sayfa adresine git");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("webelementleri kullanabilmek icin nesne olustur");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();
        googleAramaPage.aramaKutusu.sendKeys("techproeducation"+ Keys.ENTER);
       extentTest.info("3sn bekle");
        Thread.sleep(3000);
        extentTest.info("linkleri karsilastir");
        boolean linkVarmi =false;
        for (WebElement w: googleAramaPage.tumLinkler){
            if(w.getText().contains("techproeducation123")){
                linkVarmi = true;
                break;
            }
        }
        Assert.assertTrue(linkVarmi);
        extentTest.pass("test passed");
    }


}
