package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginPageTest extends TestBase {

    @Test
    public void test() {
        driver.get("http://fhctrip-qa.com/Account/Logon");

        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userNameKutusu.sendKeys("manager2");
        loginPage.passwordKutusu.sendKeys("Man1ager2!");
        loginPage.giris.click();
    }
}