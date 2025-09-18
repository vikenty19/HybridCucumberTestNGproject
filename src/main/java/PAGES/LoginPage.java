package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static Utils.CommonUtilsMethods.getEmailWithTimeStamp;

public class LoginPage extends BasePage{


    By emailLocator = By.id("input-email");
    By passwordLocator= By.id("input-password");
    By submitLocator =By.cssSelector("[type='submit']");
    By accountCreatedLocator=By.cssSelector("#content>h2");
    By warningLocator = By.cssSelector(".alert");


    public void enterEmail(String string){
          enterTextIntoField(emailLocator,string);
    }
    public void enterValidPassword(String string) {
        enterTextIntoField(passwordLocator,string);
    }
    public void clickSubmitBtn(){
        clickOnElement(submitLocator);
    }
    public boolean isAccountInfoDisplayed(){
        WebElement accountCreated = waitUntilVisible(accountCreatedLocator);
        return accountCreated.isDisplayed();
    }
    public void enterInvalidPassword(String string){

        enterTextIntoField(passwordLocator,string);
    }
    public void enterInvalidEmail(){
        enterTextIntoField(emailLocator,getEmailWithTimeStamp());
    }
    public String getWarningMessageText(){
         return getTextFromElement(warningLocator);
    }

}
