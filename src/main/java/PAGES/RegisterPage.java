package PAGES;

import Utils.CommonUtilsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        WebElement firstNameField = wait.until(ExpectedConditions
                .elementToBeClickable(firstNameLocator));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement firstNameField = wait.until(ExpectedConditions
                .elementToBeClickable(lastnameLocator));
        firstNameField.sendKeys(lastName);
    }

    public void enterDuplicateEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions
                .elementToBeClickable(emailFieldLocator));
        emailField.sendKeys(email);

    }

    public void enterUniqueEmail() {
        WebElement emailField = wait.until(ExpectedConditions
                .elementToBeClickable(emailFieldLocator));
        emailField.sendKeys(CommonUtilsMethods.getEmailWithTimeStamp());
    }

    public void enterPhoneNumber(String phone) {
        WebElement phoneNumber = wait.until(ExpectedConditions
                .elementToBeClickable(phoneLocator));
        phoneNumber.sendKeys(phone);
    }

    public void createPassword(String password) {
        WebElement newPassword = wait.until(ExpectedConditions
                .elementToBeClickable(createPasswordLocator));
        newPassword.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPassword = wait.until(ExpectedConditions
                .elementToBeClickable(confirmPassLocator));
        confirmPassword.sendKeys(password);
    }

    public void selectYesPrivacyPolicy() {
        driver.findElement(agreeBox).click();
    }

    public void selectYesInNewsLetterBox() {
        driver.findElement(newsLetterLocator).click();
    }

    public void clickOnContinueBtn() {
        driver.findElement(continueBtnLocator).click();
    }

    public String getWarningMessageText() {
        WebElement message = wait.until(ExpectedConditions
                .elementToBeClickable(warningMessageLocator));
        return message.getText();
    }

    public String accountCreatedText() {
        WebElement message =wait.until(ExpectedConditions
                .elementToBeClickable(accountCreatedLocator));
        return message.getText();
    }

    public String getFirstNameWarningText() {
        WebElement fNameWarning = wait.until(ExpectedConditions
                .elementToBeClickable(nameWarningLocator));
        return fNameWarning.getText();

    }

    public String getLastNameWarningText() {
        WebElement lastNameWarning = wait.until(ExpectedConditions
                .elementToBeClickable(lastNameWarningLocator));
        return lastNameWarning.getText();
    }

    public String getEmailWarningText() {
        WebElement emailWarning = wait.until(ExpectedConditions
                .elementToBeClickable(emailWarningLocator));
        return emailWarning.getText();
    }

}
