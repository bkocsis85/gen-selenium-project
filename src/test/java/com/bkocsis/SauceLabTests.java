package com.bkocsis;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.bkocsis.pages.*;
import com.bkocsis.utils.AccountReader;
import org.testng.annotations.Test;


public class SauceLabTests extends BaseTest {

    @Test(description = "Sauce Demo page - Purchase process E2E test")
    public void verifyPurchaseProcess() {

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage();
        SauceDemoCartPage cartPage = new SauceDemoCartPage();
        SauceDemoCheckoutStepOnePage checkoutStepOnePage = new SauceDemoCheckoutStepOnePage();
        SauceDemoCheckoutStepTwoPage checkoutStepTwoPage = new SauceDemoCheckoutStepTwoPage();
        SauceDemoConfirmationPage confirmationPage = new SauceDemoConfirmationPage();
        AccountReader account = new AccountReader();

        loginPage.visitPage();
        loginPage.fillUserName(account.readAccountFromFile().getUsername());
        loginPage.fillPassword(account.readAccountFromFile().getPassword());
        loginPage.clickLoginBtn();
        inventoryPage.addBackpack();
        inventoryPage.addJacket();

        assertEquals(inventoryPage.getNumberOfItemsInCart(), "2");

        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.fillCustomerForm("Balazs", "Kocsis", "1188");
        checkoutStepOnePage.clickContinue();
        checkoutStepTwoPage.clickFinish();

        assertTrue(confirmationPage.isThankYouMsgDisplayed());
    }

    @Test(description = "Sauce Demo page - verify login functionality and footer")
    public void verifyErrorMsgAndFooter() {

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage();

        loginPage.visitPage();
        loginPage.clickLoginBtn();

        assertEquals(loginPage.getErrorMsg(), "Epic sadface: Username is required");

        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginBtn();
        inventoryPage.scrollDown();

        assertTrue(inventoryPage.getFooterText().contains("2024"));
        assertTrue(inventoryPage.getFooterText().contains("Terms of Service"));
    }
}
