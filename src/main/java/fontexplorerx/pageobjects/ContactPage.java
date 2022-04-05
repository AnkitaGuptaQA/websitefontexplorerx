package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BaseClass {
    @FindBy(xpath = "//p[contains(text(),'We’ll get back to you as fast as possible. Please ')]")
    WebElement title;

    @FindBy(xpath = "//input[@id='Name']")
    WebElement contactName;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement contactEmail;
    @FindBy(xpath = "//select[@id='CountryCode']")
    WebElement selectCountry;
    @FindBy(xpath = "//select[@id='SupportType']")
    WebElement question;
    @FindBy(xpath = "//input[@id='Subject']")
    WebElement subject;
    @FindBy(xpath = "//textarea[@id='Message']")
    WebElement message;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement clickOnSubmit;


    public ContactPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean verifyTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),title);
    }
    public ContactPage addName(String CName) throws Throwable {
        Action.type(contactName,CName);
        return new ContactPage();
    }
    public ContactPage addEmail(String CEmail) throws Throwable {
        Action.type(contactEmail,CEmail);
        return new ContactPage();
    }
    public ContactPage selectCountry(String coNames) throws Throwable {
        Action.selectByVisibleText( coNames , selectCountry);
        return new ContactPage();
    }
    public ContactPage selectQuestion(String generalQuestion) throws Throwable{
        Action.selectByVisibleText(generalQuestion,question);
        return new ContactPage();
    }
    public ContactPage addSubject(String contactSubject) throws Throwable {
        Action.type(subject, contactSubject);
        return new ContactPage();
    }
    public ContactPage addMessage(String contactMessage) throws Throwable{
        Action.type(message,contactMessage);
        return new ContactPage();
    }
    public ContactPage submitForm() throws Throwable{
        Action.click(getDriver(),clickOnSubmit);
        return new ContactPage();
    }



}
