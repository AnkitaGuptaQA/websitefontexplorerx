package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends BaseClass {

    @FindBy(xpath = "//h3[contains(text(),'Congrats! your card has been approved')]")
    WebElement thankyouText;


@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[2]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")
WebElement downloadLicense;

public void ThankYouPage(){
    PageFactory.initElements(getDriver(),this);
}

public ThankYouPage verifythabkyoutext() throws Throwable {
   // Action.explicitWait(thankyouText,5000);
    System.out.println(Action.getTitle());
    Action.isDisplayed(getDriver(),thankyouText);
    return new ThankYouPage();


}

public ThankYouPage downloadLicenseButton() throws Throwable {
    Action.fluentWait(getDriver(),downloadLicense,10000);

   // Action.scrollByVisibilityOfElement(downloadLicense);
//    Action.click(getDriver(),downloadLicense);
    return new ThankYouPage();
}

}
