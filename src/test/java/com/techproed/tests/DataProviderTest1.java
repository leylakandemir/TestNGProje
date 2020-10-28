package com.techproed.tests;
import com.techproed.pages.FhcTripLoginNewPage;
import com.techproed.utilities.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
    @Test(dataProvider = "bilgiler")
    public void loginTest(String kullanici, String sifre){
        Driver.getDriver().get("http://fhctrip-qa.com/Account/LogOn");
        FhcTripLoginNewPage loginNewPage= new FhcTripLoginNewPage();
        loginNewPage.userNameKutusu.sendKeys(kullanici);
        loginNewPage.passwordKutusu.sendKeys(sifre);
        loginNewPage.loginButonu.click();
    }
    @DataProvider(name = "bilgiler")
    public Object[][] getBilgiler(){
        Object[][] array = new Object[3][2];
        array[0][0]="manage";
        array[0][1]="sifre";

        array[1][0]="manager2";
        array[1][1]="sifre";

        array[2][0]="manager2";
        array[2][1]="Man1ager2!";

        return array;

    }

}
