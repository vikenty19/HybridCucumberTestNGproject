package PAGES;

import Utils.CommonUtilsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage extends BasePage {

    By firstNameLocator = By.id("input-firstname");
    By lastnameLocator = By.id("input-lastname");
    By emailFieldLocator = By.id("input-email");
    By phoneLocator = By.id("input-telephone");
    By createPasswordLocator = By.id("input-password");
    By confirmPassLocator = By.id("input-confirm");
    By agreeBox = By.name("agree");
    By newsLetterLocator = By.xpath("//input[@name='newsletter'][@value='1']");
    By continueBtnLocator = (By.xpath("//input[@type='submit']"));
    By warningMessageLocator = By.cssSelector(".alert");
    By accountCreatedLocator = By.cssSelector("#content>h1");
    By nameWarningLocator = By.xpath("//input[@id='input-firstname']/following-sibling::div");
    By lastNameWarningLocator = By.xpath("//input[@id='input-lastname']/following-sibling::div");
    By emailWarningLocator = By.xpath("//input[@id='input-email']/following-sibling::div");

    public void enterFirstName(String firstName) {
        enterTextIntoField(firstNameLocator, firstName);
    }

    public void enterLastName(String lastName) {
        enterTextIntoField(lastnameLocator, lastName);
    }

    public void enterDuplicateEmail(String email) {
        enterTextIntoField(emailFieldLocator, email);
    }

    public void enterUniqueEmail() {
        enterTextIntoField(emailFieldLocator, CommonUtilsMethods.getEmailWithTimeStamp());
    }

    public void enterPhoneNumber(String phone) {
        enterTextIntoField(phoneLocator, phone);
    }

    public void createPassword(String password) {
        enterTextIntoField(createPasswordLocator, password);
    }

    public void confirmPassword(String password) {
        enterTextIntoField(confirmPassLocator, password);
    }

    public void selectYesPrivacyPolicy() {
        clickOnElement(agreeBox);
    }

    public void selectYesInNewsLetterBox() {
        clickOnElement(newsLetterLocator);
    }

    public void clickOnContinueBtn() {
        clickOnElement(continueBtnLocator);
    }

    public String getWarningMessageText() {
        return getTextFromElement(warningMessageLocator);
    }

    public String accountCreatedText() {
        return getTextFromElement(accountCreatedLocator);
    }

    public String getFirstNameWarningText() {
        return getTextFromElement(nameWarningLocator);
    }

    public String getLastNameWarningText() {
          return getTextFromElement(lastNameWarningLocator);
    }

    public String getEmailWarningText() {
         return getTextFromElement(emailWarningLocator);
    }

}
