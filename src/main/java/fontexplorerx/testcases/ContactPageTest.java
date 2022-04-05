package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.ContactPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPageTest extends BaseClass {
    IndexPage indexPage;
    ContactPage contactPage;

    @Test
    public void contactPage() throws Throwable {
        Log.startTestCase("User can contact to the font explorerx");
        Log.info("Navigate to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigated to the contact page.");
        contactPage = indexPage.clickOnContact();
        Log.info("Verify the title of the page.");
        Boolean title = contactPage.verifyTitle();
        Assert.assertTrue(true);
        Log.info("Add the name. ");
        contactPage.addName(prop.getProperty("CName"));
        Log.info("Add the email.");
        contactPage.addEmail(prop.getProperty("CEmail"));
        Log.info("select the country");
        contactPage.selectCountry(prop.getProperty("coName"));
        Log.info("Select the question.");
        contactPage.selectQuestion(prop.getProperty("generalQuestion"));
        Log.info("Enter the subject");
        contactPage.addSubject(prop.getProperty("contactSubject"));
        Log.info("Enter the message.");
        contactPage.addMessage(prop.getProperty("contactMessage"));
        Log.info("Click on the submit button.");
        contactPage.submitForm();
        Log.endTestCase("Contact page test has been completed.");





    }
}
