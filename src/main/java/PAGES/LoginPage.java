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
 /*   private WebDriver driver;
   private WebDriverWait wait;
    public LoginPage(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }*/
    By emailLocator = By.id("input-email");
    By passwordLocator= By.id("input-password");
    By submitLocator =By.cssSelector("[type='submit']");
    By accountCreatedLocator=By.cssSelector("#content>h2");
    By warningLocator = By.cssSelector(".alert");


    public void enterEmail(String string){
        WebElement emailField =  wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        emailField.sendKeys(string);
    }
    public void enterValidPassword(String string) {
        WebElement passwordField =  wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        passwordField.sendKeys(string);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitLocator).click();
    }
    public boolean isAccountInfoIsDisplayed(){
        WebElement accountCreated = wait
                .until(ExpectedConditions.visibilityOfElementLocated(accountCreatedLocator));
        return accountCreated.isDisplayed();
    }
    public void enterInvalidPassword(String string){
        WebElement passwordField =  wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        passwordField.sendKeys(string);
    }
    public void enterInvalidEmail(){
        WebElement emailLField =  wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        emailLField.sendKeys(getEmailWithTimeStamp());
    }
    public String getWarningMessageText(){
        WebElement warnMessage = wait.until(ExpectedConditions.elementToBeClickable(warningLocator));
        return warnMessage.getText();
    }

}
