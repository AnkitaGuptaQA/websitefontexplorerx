package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(css = "a[href='/account']")
    WebElement loggedinUserName;

    @FindBy(css = "a[href='/logout']")
    WebElement Logoutlink;


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

    public String validatelogoutText(){
        String logoutText = Logoutlink.getText();
        return logoutText;
    }

    public String getcurrURL(){
        String homepageURL = getDriver().getCurrentUrl();
        return homepageURL;
    }
}
