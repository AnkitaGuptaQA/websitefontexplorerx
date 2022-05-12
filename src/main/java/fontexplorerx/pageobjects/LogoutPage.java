package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {

   @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutText;

    public LogoutPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean verifyText() throws Throwable{
        return Action.isDisplayed(getDriver(),logoutText);
    }

    public LogoutPage clickOnLogout() throws Throwable {
        Action.fluentWait(getDriver(),logoutText,3000);
//        Action.click(getDriver(),logoutText);
        return new LogoutPage();

    }
    public IndexPage clickOnLogoutPage() throws Throwable {
        Action.fluentWait(getDriver(),logoutText,3000);
//        Action.click(getDriver(),logoutText);
        return new IndexPage();

    }
}
