package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Date;

import static Utils.CommonUtilsMethods.getEmailWithTimeStamp;

public class LoginPage extends BasePage{


    By emailLocator = By.id("input-email");
    By passwordLocator= By.id("input-password");
    By submitLocator =By.cssSelector("[type='submit']");
    By accountCreatedLocator=By.cssSelector("#content>h2");
    By warningLocator = By.cssSelector(".alert");


    public void enterEmail(String string){
        WebElement emailField =  waitUntilClickable(emailLocator);
        emailField.sendKeys(string);
    }
    public void enterValidPassword(String string) {
        WebElement passwordField = waitUntilClickable(passwordLocator);
        passwordField.sendKeys(string);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitLocator).click();
    }
    public boolean isAccountInfoIsDisplayed(){
        WebElement accountCreated = waitUntilVisible(accountCreatedLocator);
        return accountCreated.isDisplayed();
    }
    public void enterInvalidPassword(String string){
        WebElement passwordField =  waitUntilClickable(passwordLocator);
        passwordField.sendKeys(string);
    }
    public void enterInvalidEmail(){
        WebElement emailLField = waitUntilClickable(emailLocator);
        emailLField.sendKeys(getEmailWithTimeStamp());
    }
    public String getWarningMessageText(){
        WebElement warnMessage = waitUntilVisible(warningLocator);
        return warnMessage.getText();
    }

}
