package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThankYouPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    ThankYouPage thankYouPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;

    @Test
public void verifyTitle() throws Throwable {
    Log.startTestCase("Thank you page.");
    Log.info("Navigate to the index page.");
    indexPage = new IndexPage();
    Log.info("Navigate to the product page.");
    productsPage = indexPage.clickOnProduct();
    Log.info ("Navigate to the cart page.");
    addToCartPage = productsPage.clickOnBuyButton();
    Log.info("Navigate to the checkout page.");
    loginPage = addToCartPage.proceedToCheckout();
    Log.info("Navigate to the login page.");
    checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
    Log.info("Select the payment gateway");
    checkoutPage.clickOnCreditCard();
    Log.info("Enter the checkout page details.");
    checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
    checkoutPage.clickONTerms();
    Thread.sleep(3000);
    thankYouPage = checkoutPage.clickOnPlaceYourOrder();
    Thread.sleep(5000);

    Log.info("Display the title of the thank you page.");
    Boolean title = thankYouPage.verifytitle();
    Assert.assertTrue(title);
    Log.info("Download the license");
    thankYouPage.downloadLicenseButton();
    Log.endTestCase("Verified the thank you page.");

}
}
