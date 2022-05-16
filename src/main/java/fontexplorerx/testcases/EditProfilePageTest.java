package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.EditProfilePage;
import fontexplorerx.pageobjects.HomePage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.LoginPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfilePageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    EditProfilePage editProfilePage;

    @Test
    public void editProfile() throws Throwable {
        Log.startTestCase("Edit your profile.");
        Log.info("Navigate to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigate to the login page");
       loginPage =  indexPage.clickOnSignIn();
        Log.info("The user is logged in.");
        editProfilePage = loginPage.login2(prop.getProperty("username"), prop.getProperty("password") );
        Log.info("Navigate to the profile page.");
        editProfilePage.clickOnProfile();
        Log.info("Enter the details.");
        editProfilePage.addCompanyandVatDetails(prop.getProperty("nameCompany"),prop.getProperty("vatEurope") );
        Log.info("Click on the save button");
        editProfilePage.clickOnSave();
    }

    @Test
    public void updatePassword() throws Throwable{
        Log.startTestCase("Update the password");
        Log.info("Navigate to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigate to the login page");
        loginPage =  indexPage.clickOnSignIn();
        Log.info("The user is logged in.");
        editProfilePage = loginPage.login2(prop.getProperty("username"), prop.getProperty("password") );
        Log.info("Navigate to the profile page.");
        editProfilePage.clickOnProfile();
        Log.info("Navigate to the login data section");
        editProfilePage.clickOnLoginData();
        Log.info("Change the password.");
        editProfilePage.changePasswordLoginData(prop.getProperty("password"), prop.getProperty("conpassword") );
        editProfilePage.clickOnChangePassword();
        Boolean confirmationmessage;
        confirmationmessage = editProfilePage.verifyConfirmation();
        Assert.assertTrue(confirmationmessage);
        Log.endTestCase("Verifeid the update password.");
    }

    @Test
    public void previousOrder() throws Throwable {
        Log.startTestCase("Update the password");
        Log.info("Navigate to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigate to the login page");
        loginPage = indexPage.clickOnSignIn();
        Log.info("The user is logged in.");
        editProfilePage = loginPage.login2(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("Navigate to the profile page.");
        editProfilePage.clickOnProfile();
        Log.info("Navigate to the previous order.");
        editProfilePage.clickOnPreviousOrder();
        Log.info("Expand the order.");
        editProfilePage.clickOnOrder();
        Log.info("Download the invoice.");
        editProfilePage.clickOnInvoiceButton();
        Log.info("Download the license file.");
        editProfilePage.clickOnDownloadButton();
        Log.endTestCase("Verified the previous order.");

    }

}
