package PAGES;

import Utils.CommonUtilsMethods;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void enterFirstName(String firstName){
    //  WebElement firstNameField =  wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
        WebElement firstNameField =CommonUtilsMethods.waitUntilClickable(firstNameLocator);
                firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement firstNameField =CommonUtilsMethods.waitUntilClickable(lastnameLocator);
        firstNameField.sendKeys(lastName);
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


}
