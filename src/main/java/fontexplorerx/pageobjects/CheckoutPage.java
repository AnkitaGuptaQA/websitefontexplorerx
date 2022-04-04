package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass {

    @FindBy(css = ".blue-header")
    WebElement checkoutPageTitle;

    @FindBy(xpath = "//input[@id='card-new']")
    WebElement selectpaymentgateway;

    @FindBy(xpath = "//input[@id='CheckOutCardPayment_Name']")
    WebElement cardName;

    @FindBy(name = "CheckOutCardPayment.AccountNumber")
    WebElement cardNumber;

    @FindBy(xpath = "//select[@id='CheckOutCardPayment_ExpirationMonth']")
    WebElement cardMonth;

    @FindBy(xpath = "//select[@id='CheckOutCardPayment_ExpirationYear']")
    WebElement cardYear;

    @FindBy(name = "CheckOutCardPayment.CvvNumber")
    WebElement securityCode;

    @FindBy(xpath = "//input[@id='CheckOutCardPayment_LicensesAndTerms']")
    WebElement paymentTerms;

    @FindBy(xpath = "//button[@type='button']")
    WebElement placeOrderButton;




    public CheckoutPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getCheckoutTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),checkoutPageTitle);
    }
    public CheckoutPage clickOnCreditCard() throws Throwable{
        Action.click(getDriver(),selectpaymentgateway);
        return new CheckoutPage();
    }

    public CheckoutPage enterCardDetails(String cname, String cnumber, String cmonth, String cYear , String scode) throws Throwable {

        Action.type(cardName, cname);
        Action.type(cardNumber,cnumber);
        Action.selectByVisibleText(cmonth,cardMonth);
        Action.selectByVisibleText(cYear,cardYear);
        Action.type(securityCode,scode);
        return new CheckoutPage();
    }
    public CheckoutPage clickONTerms() throws Throwable {
        Action.click(getDriver(),paymentTerms);
        return new CheckoutPage();
    }
    public ThankYouPage clickOnPlaceYourOrder() throws Throwable {
        Action.click(getDriver(),placeOrderButton);
        return new ThankYouPage();
    }

}
