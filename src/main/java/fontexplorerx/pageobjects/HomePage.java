package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(css = "span[class='user-info'] a")
    WebElement loggedinUserName;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutText;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String gethomePageTitle(String homepagetitle){
        homepagetitle = getDriver().getTitle();
        return homepagetitle;
    }

    public String validateloggedusername() throws Throwable {
        Action.pageLoadTimeOut(getDriver(),5000);
        Action.fluentWait(getDriver(),loggedinUserName,5000);
        String loggedUserName = loggedinUserName.getText();
        return loggedUserName;
    }

    public boolean verifyText() throws Throwable{
        return Action.isDisplayed(getDriver(),logoutText);
    }

    public LoginPage clickOnLogout() throws Throwable {
        Action.click(getDriver(),logoutText);
        return new LoginPage();

    }

    public String getcurrURL(){
        String homepageURL = getDriver().getCurrentUrl();
        return homepageURL;
    }
}
