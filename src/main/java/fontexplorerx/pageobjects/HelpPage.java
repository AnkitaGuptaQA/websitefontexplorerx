package fontexplorerx.pageobjects;


import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Help']")
    WebElement helpTitle;

    @FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[1]/nav[1]/a[2]")
    WebElement clickOnDownloads;

    @FindBy(xpath = "//a[@class='btn-blue js-link-tooltip']")
    WebElement downloadMacBuild;

    @FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[3]/a[1]")
    WebElement downloadWindowsBuild;

//    @FindBy(xpath = "//a[@href='https://fex.linotype.com/download/server/FontExplorerXServer.zip']")
    @FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/div[2]/div[1]/section[1]/div[3]/a[1]")
    WebElement downloadServerBuild;

    public HelpPage(){
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
    public boolean verifyTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),helpTitle);
    }

    public HelpPage downloadsButton() throws Throwable {
//        Action.scrollByVisibilityOfElement(clickOnDownloads);
        Action.fluentWait(getDriver(),clickOnDownloads,3000);
        return new HelpPage();
    }

    public fontexplorerx.pageobjects.FreeTrialPage downloadMacBuilds() throws Throwable {
        Action.fluentWait(getDriver(),downloadMacBuild,3000);
        return new fontexplorerx.pageobjects.FreeTrialPage();
    }

    public HelpPage downloadWindowsBuilds() throws Throwable{
        Action.fluentWait(getDriver(),downloadWindowsBuild,3000);
        Thread.sleep(5000);
        return new HelpPage();
    }

    public HelpPage downloasServerBuild() throws Throwable{
        Action.fluentWait(getDriver(),downloadServerBuild,3000);
        Thread.sleep(5000);
        return new HelpPage();
    }
}
