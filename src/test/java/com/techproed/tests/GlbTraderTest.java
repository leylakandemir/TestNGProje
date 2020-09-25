package com.techproed.tests;

import com.techproed.pages.Glbtraderpage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GlbTraderTest extends TestBaseFinal {

    @Test
    public void glbtraderTest(){
        extentTest = extentReports.createTest("Baslik Karsilastirma", "urun ismi ve sayfa basligi karsilastirma");
        extentTest.info("sayfaya gittik");
        Driver.getDriver().get(ConfigurationReader.getProperty("glbtrader_url"));

        extentTest.info("Nesne uretiyoruz");
        Glbtraderpage glbtraderpage = new Glbtraderpage();

        extentTest.info("Dropdown kullanmak icin select clasindan nesne uretip 6.secenegi seciyoruz");
        Select select =  new Select(glbtraderpage.kategorilerDropDown);
        select.selectByIndex(6);
        extentTest.info("arama kutusunda camera yi aratiyoruz");
        glbtraderpage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("glb_search")+ Keys.ENTER);
        extentTest.info("ilk urunun ismini alip tikladik urune");
        String urunIsmi= glbtraderpage.sonuclarListesi.get(2).getText();
        glbtraderpage.sonuclarListesi.get(2).click();
        extentTest.info("3sn bekliyoruz sayfaya gecis icin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.info("Sayfanin basligini aldik");
        String sayfaBasligi = Driver.getDriver().getTitle();
        extentTest.info("Assert islemi yaptik");
        Assert.assertEquals(urunIsmi,sayfaBasligi);
        extentTest.pass("Testimiz passed");
    }


}
