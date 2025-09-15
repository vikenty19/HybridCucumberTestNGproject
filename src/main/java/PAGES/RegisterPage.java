package PAGES;

import Utils.CommonUtilsMethods;
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
      WebElement firstNameField =  wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement firstNameField =  wait.until(ExpectedConditions.elementToBeClickable(lastnameLocator));
        firstNameField.sendKeys(lastName);
    }
    public void enterUniqueEmail(){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.sendKeys(CommonUtilsMethods.getEmailWithTimeStamp());
    }
    public void enterPhoneNumber(String phone){
        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(phoneLocator));
        phoneNumber.sendKeys(phone);
    }
    public void createPassword(String password){
        WebElement newPassword =  wait.until(ExpectedConditions.elementToBeClickable(createPasswordLocator));
        newPassword.sendKeys(password);
    }
    public void confirmPassword(String password){
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(confirmPassLocator));
        confirmPassword.sendKeys(password);
    }


}
