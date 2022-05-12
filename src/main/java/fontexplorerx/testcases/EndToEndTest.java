package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    LogoutPage logoutPage;
    PaymentPage paymentPage;
    HomePage homePage;
    ThankYouPage thankYouPage;


    @Test
    public void endToEndTest() throws Throwable {
        Log.startTestCase("endToEnd");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigated on the product page.");
        productsPage = indexPage.clickOnProduct();
        Log.info("Selected the pro license and added to cart.");
        addToCartPage = productsPage.clickOnBuyButton();
        Log.info("User proceed to checkout for the selected license.");
        loginPage = addToCartPage.proceedToCheckout();
        Log.info("The user gets login");
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password") );
        Boolean result = checkoutPage.getCheckoutTitle();
        Assert.assertTrue(result);
        Thread.sleep(5000);
        Log.info("Select the payment gateway.");
        checkoutPage.paywithCreditCard();
         Log.info("Enter the checkout page details.");
//         checkoutPage.addCardName(prop.getProperty("cname"));
//        checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
        Log.info("Click on the payment terms and condition.");
        checkoutPage.clickONTerms();
       Log.info("Click on the PLace your order option.");
        thankYouPage = checkoutPage.clickOnPlaceYourOrder();
         Log.info("Download the license.");
        thankYouPage.downloadLicenseButton();
//        Log.info("Logout from the website.");
//        indexPage = logoutPage.clickOnLogoutPage();
        Log.endTestCase("endToEnd");




    }
}
