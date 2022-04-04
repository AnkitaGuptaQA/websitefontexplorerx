package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import fontexplorerx.utility.Log;

public class IndexPageTest extends BaseClass {
    IndexPage indexPage;

    @Test
    public void verifyLogo() throws Throwable{
        Log.startTestCase("verifylogo");
        Log.info("Navigated to the login page");
        indexPage = new IndexPage();
        Log.info("Validate the logo of the fontexplprerx application.");
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifylogo");
    }
    @Test
    public void verifytitle(){
        Log.startTestCase("Verifytitle");
        Log.info("Validate the title of the index page.");
        String acttitle = indexPage.getIndexPageTitle();
        Assert.assertEquals(acttitle,"Font Manager for Mac with Free Trial | FontExplorer® X Pro");
        Log.endTestCase("Verifytitle");
    }

}
