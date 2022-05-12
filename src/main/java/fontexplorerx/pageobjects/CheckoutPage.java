package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass {

    @FindBy(css = ".blue-header")
    WebElement checkoutPageTitle;

    @FindBy(xpath = "//input[@id='card-new']")
//    @FindBy(xpath = "//input[@id='189839']")
    WebElement selectpaymentgateway;

   // @FindBy(xpath = "//input[@id='189839']")
//    @FindBy(id = "card-new")
   // @FindBy(name = "CheckOutCardPayment.CreditCardTypeId")

//    @FindBy(xpath = "//*[@id=\"card-new\"]")
            @FindBy(xpath = "//*[@id=\"189839\"]")
    WebElement selectCreditCard;

    @FindBy(xpath = "//input[@id='CheckOutCardPayment_Name']")
    WebElement cardName;

    @FindBy(xpath = "//*[@id=\"CheckOutCardPayment_Name\"]")
    WebElement checkCardName;

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

    @FindBy(xpath = "//button[contains(text(),'Place Your Order')]")
    WebElement placeOrderButton;




    public CheckoutPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getCheckoutTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),checkoutPageTitle);
    }
    public CheckoutPage clickOnCreditCard() throws Throwable{
        Action.pageLoadTimeOut(getDriver(),5000);
        Action.scrollByVisibilityOfElement(selectpaymentgateway);
        Action.click(getDriver(),selectpaymentgateway);
        return new CheckoutPage();
    }
    public CheckoutPage paywithCreditCard() throws Throwable{
//        Action.scrollByVisibilityOfElement(selectCreditCard);
        Action.fluentWait(getDriver(),selectCreditCard,3000);
//        Action.click(getDriver(),selectCreditCard);
        return new CheckoutPage();
    }
//    public CheckoutPage addCardName(String cname) throws Throwable{
//        Action.fluentWait(getDriver(),checkCardName,20000);
//        Action.type(checkCardName,cname);
//        return new CheckoutPage();
//    }

    public CheckoutPage enterCardDetails(String cname, String cnumber, String cmonth, String cYear , String scode) throws Throwable {

        Action.type(cardName, cname);
        Action.type(cardNumber,cnumber);
        Action.selectByVisibleText(cmonth,cardMonth);
        Action.selectByVisibleText(cYear,cardYear);
        Action.type(securityCode,scode);
        return new CheckoutPage();
    }


    public CheckoutPage clickONTerms() throws Throwable {
        Action.fluentWait(getDriver(),paymentTerms,5000);
//        Action.click(getDriver(),paymentTerms);
        return new CheckoutPage();
    }
    public ThankYouPage clickOnPlaceYourOrder() throws Throwable {
//        Action.scrollByVisibilityOfElement(placeOrderButton);
//        Action.click(getDriver(),placeOrderButton);
        Action.fluentWait(getDriver(),placeOrderButton,3000);
        return new ThankYouPage();
    }

}
