package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Payment extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    ThankYouPage thankYouPage;

@Test
    public void purchaseProLicense() throws Throwable {
        indexPage = new IndexPage();
        productsPage = indexPage.clickOnProduct();
        addToCartPage = productsPage.clickOnBuyButton();
        loginPage = addToCartPage.proceedToCheckout();
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password") );
        checkoutPage.clickOnCreditCard();
    checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
    checkoutPage.clickONTerms();
    Thread.sleep(3000);
    thankYouPage = checkoutPage.clickOnPlaceYourOrder();
    Thread.sleep(5000);
    thankYouPage.downloadLicenseButton();
    String test;
    test = String.valueOf(thankYouPage.verifythabkyoutext());
    System.out.println(test);

//    Boolean thanktitle;
//    thanktitle = thankYouPage.verifytitle();
////    Assert.assertTrue(thanktitle);
//    System.out.println(thanktitle);

    }

    @Test
    public void purchaseStudentLicense() throws Throwable{
    indexPage = new IndexPage();
    productsPage = indexPage.clickOnProduct();
    productsPage.clickOnStudent();
    addToCartPage = productsPage.clickOnStudentBuyButton();
    loginPage = addToCartPage.proceedToCheckout();
    checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password") );
    checkoutPage.clickOnCreditCard();
    checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
    checkoutPage.clickONTerms();
    Thread.sleep(3000);
    thankYouPage = checkoutPage.clickOnPlaceYourOrder();
    Thread.sleep(5000);
    }

    @Test
    public void purchaseUpgradeLicense() throws Throwable{
        indexPage = new IndexPage();
        productsPage = indexPage.clickOnProduct();
        productsPage.clickOnUpgradeButton();
        productsPage.addSerialNumber(prop.getProperty("serialno"));
        addToCartPage = productsPage.clickOnUpgrade();
        loginPage = addToCartPage.proceedToCheckout();
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password") );
        checkoutPage.clickOnCreditCard();
        checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
        checkoutPage.clickONTerms();
        Thread.sleep(3000);
        //thankYouPage = checkoutPage.clickOnPlaceYourOrder();
        Thread.sleep(5000);
    }
}
