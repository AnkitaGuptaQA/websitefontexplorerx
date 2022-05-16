package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import fontexplorerx.testcases.ProductPageTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseClass {

    @FindBy(xpath = "//h1[contains(text(),'Take control of your font collection.')]")
    WebElement productTitle;

@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/form[1]/input[2]")
//@FindBy(xpath = "//input[@class='btn-buy dev-product-action-selector']")
    WebElement proBuyButton;

@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/form[1]/input[2]")
WebElement buyButton;

    @FindBy(xpath = "//a[@class='btn-blue-small dev-product-action-selector']")
    WebElement upgradeBuyButton;

    @FindBy(linkText = "special offers")
    WebElement studentLink;

    @FindBy(xpath = "//h1[normalize-space()='Upgrade Version']")
    WebElement upgradetitlw;

    @FindBy(xpath = "//p[normalize-space()='Serial Number is required.']")
    WebElement blankVerification;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/section[1]/div[1]/form[1]/input[1]")
    WebElement upgradeButton;


    @FindBy(xpath = "//input[@id='sn']")
    WebElement serialNumber;

    @FindBy(xpath = "//h1[normalize-space()='Special offers for Students and Educators.']")
    WebElement studentTitle;


    @FindBy(xpath = "//input[@value='Buy']")
    WebElement studentBuyButton;

    public ProductsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getProductTitle() throws Throwable{
        return Action.isDisplayed(getDriver(),productTitle);
    }

    public AddToCartPage clickOnProButton() throws Throwable {
        Action.fluentWait(getDriver(),proBuyButton,3000);
        return new AddToCartPage();
    }
    public AddToCartPage clickOnBuyButton() throws Throwable {
        Action.scrollByVisibilityOfElement(buyButton);
        Action.click(getDriver(),buyButton);
        return new AddToCartPage();
    }

    public ProductPageTest clickOnUpgradeButton() throws Throwable{
        Action.scrollByVisibilityOfElement(upgradeBuyButton);
        Action.click(getDriver(),upgradeBuyButton);
//        Action.fluentWait(getDriver(),upgradeBuyButton,3000);
        return new ProductPageTest();
    }

    public AddToCartPage clickOnStudent() throws Throwable{
        Action.scrollByVisibilityOfElement(studentLink);
        Action.click(getDriver(),studentLink);
        return new AddToCartPage();
    }

    public boolean verifyUpgradeTitle() throws Throwable{
       return Action.isDisplayed(getDriver(),upgradetitlw);

    }

    public ProductsPage validateblanktext() throws Throwable {
        Action.fluentWait(getDriver(),upgradeButton,3000);
        return new ProductsPage();
    }

    public boolean asssertBlankValidation() throws Throwable{
       return Action.isDisplayed(getDriver(),blankVerification);
    }

    public AddToCartPage clickOnUpgrade() throws  Throwable{
        Action.fluentWait(getDriver(),upgradeButton,3000);
        return new AddToCartPage();
    }


    public boolean verifyStudentPageTitle() throws Throwable {
      return   Action.isDisplayed(getDriver(),studentTitle);

    }

    public AddToCartPage clickOnStudentBuyButton() throws Throwable {
        Action.scrollByVisibilityOfElement(studentBuyButton);
        Action.click(getDriver(),studentBuyButton);
//        Action.fluentWait(getDriver(),studentBuyButton,3000);
        return new AddToCartPage();
    }
    public ProductsPage addSerialNumber(String serialno) throws Throwable{
        Action.type(serialNumber,serialno);
        return new ProductsPage();
    }
}
