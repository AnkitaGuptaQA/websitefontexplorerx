package fontexplorerx.testcases;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    ProductsPage upgradePage;

    @Test
    public void productPageTest() throws Throwable{
        Log.startTestCase("productPageTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();
        Log.info("Assert the product page title.");
        boolean result = productsPage.getProductTitle();
        System.out.println(result);
        Assert.assertTrue(result);

        Log.info("Click on the pro button.");
        Thread.sleep(5000);
        //addToCartPage = productsPage.clickOnProButton();
        addToCartPage = productsPage.clickOnBuyButton();
        Thread.sleep(5000);

        Log.info("Validate the title of the cart page");
        boolean atcresult = addToCartPage.getCartTitle();
        Assert.assertTrue(atcresult);
        Log.endTestCase("productPageTest");
    }

   @Test
    public void upgradePageTest() throws Throwable{
        Log.startTestCase("UpgradePageTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();

        Log.info("Navigated to the upgrade page");
        productsPage.clickOnUpgradeButton();

        Log.info("Verify the title of the page.");
        Boolean titleUpgrade = productsPage.verifyUpgradeTitle();
        Assert.assertTrue(titleUpgrade);

        Log.info("Verify the validation message for the blank click");
        productsPage.validateblanktext();
        Boolean requiredSerial;
        requiredSerial = productsPage.asssertBlankValidation();
       Assert.assertTrue(requiredSerial);
       System.out.println(requiredSerial);

       Log.info("Verify if the user can enter the details.");
       productsPage.addSerialNumber(prop.getProperty("serialno"));
       addToCartPage = productsPage.clickOnUpgrade();
       Log.info("Verify if the user can navigate to the checkout page.");
       addToCartPage.proceedToCheckout();
        Log.endTestCase("UpgradePageTest");

    }

    @Test
    public void specialOfferPageTest() throws Throwable{
        Log.startTestCase("Special Offer");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();

        Log.info("Navigated to the upgrade page");
        productsPage.clickOnStudent();

        Log.info("Verify the title of the page.");
        String titleStudent = productsPage.verifyStudentPageTitle();
        Assert.assertEquals(titleStudent,"Special offers for Students and Educators.");

        Log.info("Add the student version to cart.");
        addToCartPage = productsPage.clickOnStudentBuyButton();

        Log.info("Validate the title of the cart page");
        boolean atcresult = addToCartPage.getCartTitle();
        Assert.assertTrue(atcresult);

        Log.endTestCase("Special Offer");

    }


}
