package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends BaseClass {
@FindBy(xpath = "//h1[normalize-space()='Thank you!']")
    WebElement thankyouTitle;

@FindBy(xpath = "//button[normalize-space()='Download License']")
WebElement downloadLicense;

public void ThankYouPage(){
    PageFactory.initElements(getDriver(),this);
}

public boolean verifytitle() throws Throwable {
    Action.pageLoadTimeOut(getDriver(),5000);
    return Action.isDisplayed(getDriver(),thankyouTitle);
}
public ThankYouPage downloadLicenseButton() throws Throwable {
    Action.click(getDriver(),downloadLicense);
    return new ThankYouPage();
}
}
