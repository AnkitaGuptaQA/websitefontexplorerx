package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage extends BaseClass {
    @FindBy(xpath = "//a[normalize-space()='Ankita Gupta']")
    WebElement navigateProfile;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyName;

    @FindBy(xpath = "//input[@id='VatNo']")
    WebElement europeVat;

    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    WebElement saveButton;

    @FindBy(xpath = "//a[normalize-space()='Login data']")
    WebElement loginData;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement newPassword;

    @FindBy(xpath = "//input[@id='PasswordConfirmation']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    WebElement saveButtonPassword;

    @FindBy(xpath = "//p[normalize-space()='Log in information updated successfully']")
    WebElement messageConfirmation;

    @FindBy(xpath = "//a[normalize-space()='Previous Orders']")
    WebElement previousOrder;

    @FindBy(xpath = "//a[normalize-space()='Order No: 2336071']")
    WebElement expandOrder;
    //"/html[1]/body[1]/div[1]/div[1]/section[1]/div[4]/div[1]/a[1]"

    @FindBy(xpath = "//div[@class='order-opened']//button[@type='submit'][normalize-space()='Invoice']")
    WebElement invoiceButton;

    @FindBy(xpath = "//div[@class='order-opened']//button[@type='submit'][normalize-space()='Download License']")
    WebElement downloadLicense;

    public EditProfilePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public EditProfilePage clickOnProfile() throws Throwable {
        Action.fluentWait(getDriver(),navigateProfile,3000);
        return new EditProfilePage();
    }

    public EditProfilePage addCompanyandVatDetails(String nameCompany , String vatEurope) throws Throwable{
        Action.type(companyName,nameCompany);
        Action.type(europeVat,vatEurope);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnSave() throws Throwable{
//        Action.scrollByVisibilityOfElement(saveButton);
        Action.fluentWait(getDriver(),saveButton,3000);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnLoginData() throws Throwable{
        Action.fluentWait(getDriver(),loginData,3000);
        return new EditProfilePage();
    }

    public EditProfilePage changePasswordLoginData(String password, String conpassword) throws Throwable{
        Action.type(newPassword,password);
        Action.type(confirmPassword,conpassword);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnChangePassword() throws Throwable{
        Action.fluentWait(getDriver(),saveButtonPassword,3000);
        return new EditProfilePage();
    }

    public boolean verifyConfirmation() throws Throwable{
        return Action.isDisplayed(getDriver(),messageConfirmation);

    }

    public EditProfilePage clickOnPreviousOrder() throws Throwable{
        Action.fluentWait(getDriver(),previousOrder,3000);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnOrder()throws Throwable{
        Action.fluentWait(getDriver(),expandOrder,3000);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnInvoiceButton() throws  Throwable{
        Action.fluentWait(getDriver(),invoiceButton,3000);
        return new EditProfilePage();
    }

    public EditProfilePage clickOnDownloadButton() throws Throwable{
        Action.fluentWait(getDriver(),downloadLicense,3000);
        return new EditProfilePage();
    }



}
