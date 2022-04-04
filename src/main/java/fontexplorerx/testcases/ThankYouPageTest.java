package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.ThankYouPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;

public class ThankYouPageTest extends BaseClass {
    ThankYouPage thankYouPage;
public void verifyTitle() throws Throwable {
    Log.startTestCase("Thank you page.");
    Log.info("Display the title of the thank you page.");
    Boolean title = thankYouPage.verifytitle();
    Assert.assertTrue(true);
    Log.info("Download the license");
    thankYouPage.downloadLicenseButton();
    Log.endTestCase("Verified the thank you page.");

}
}
