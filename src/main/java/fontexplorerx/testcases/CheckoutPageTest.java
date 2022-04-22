package fontexplorerx.testcases;


import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import fontexplorerx.utility.Log;

public class CheckoutPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    ThankYouPage thankYouPage;


    @Test
    public void checkoutPageTest() throws Throwable {
        Log.startTestCase("endToEnd");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated on the product page.");
        productsPage = indexPage.clickOnProduct();

        Log.info("Selected the pro license and added to cart.");
        addToCartPage = productsPage.clickOnBuyButton();
        Thread.sleep(5000);

        Log.info("User proceed to checkout for the selected license.");
        loginPage = addToCartPage.proceedToCheckout();

        Log.info("The user gets login");
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
        Boolean result = checkoutPage.getCheckoutTitle();
        Assert.assertTrue(result);

        Log.info("Select the payment gateway.");
        checkoutPage.clickOnCreditCard();

        Log.info("Enter the checkout page details.");
        checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));

        Log.info("Click on the payment terms and condition.");
        checkoutPage.clickONTerms();

        Log.info("Click on the PLace your order option.");
        thankYouPage = checkoutPage.clickOnPlaceYourOrder();
        Log.endTestCase("endToEnd");

    }
}
