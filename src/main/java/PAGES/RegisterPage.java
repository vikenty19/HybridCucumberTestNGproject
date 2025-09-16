package PAGES;

import Utils.CommonUtilsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends HomePage{

    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstNameLocator = By.id("input-firstname");
    By lastnameLocator = By.id("input-lastname");
    By emailFieldLocator =By.id("input-email");
    By phoneLocator = By.id("input-telephone");
    By createPasswordLocator =By.id("input-password");
    By confirmPassLocator =By.id("input-confirm");
    By agreeBox =By.name("agree");
    By newsLetterLocator = By.xpath("//input[@name='newsletter'][@value='1']");
By continueBtnLocator =(By.xpath("//input[@type='submit']"));
By warningMessageLocator = By.cssSelector(".alert");
    public void enterFirstName(String firstName){
        WebElement firstNameField =CommonUtilsMethods.waitUntilClickable(firstNameLocator);
                firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement firstNameField =CommonUtilsMethods.waitUntilClickable(lastnameLocator);
        firstNameField.sendKeys(lastName);
    }
    public void enterDuplicateEmail(String email){
        WebElement emailField = CommonUtilsMethods.waitUntilClickable(emailFieldLocator);
        emailField.sendKeys(email);

    }
    public void enterUniqueEmail(){
        WebElement emailField = CommonUtilsMethods.waitUntilClickable(emailFieldLocator);
        emailField.sendKeys(CommonUtilsMethods.getEmailWithTimeStamp());
    }
    public void enterPhoneNumber(String phone){
        WebElement phoneNumber = CommonUtilsMethods.waitUntilClickable(phoneLocator);
        phoneNumber.sendKeys(phone);
    }
    public void createPassword(String password){
        WebElement newPassword =  CommonUtilsMethods.waitUntilClickable(createPasswordLocator);
        newPassword.sendKeys(password);
    }
    public void confirmPassword(String password){
        WebElement confirmPassword = CommonUtilsMethods.waitUntilClickable(confirmPassLocator);
        confirmPassword.sendKeys(password);
    }
    public void selectYesPrivacyPolicy(){
        driver.findElement(agreeBox).click();
    }
     public void selectYesInNewsLetterBox(){
         driver.findElement(newsLetterLocator).click();
     }
     public void clickOnContinueBtn(){
         driver.findElement(continueBtnLocator).click();
     }
     public String warningMessageAboutDuplicateEmailText(){
         WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(warningMessageLocator));
         return message.getText();

     }

}
