package Utils;

import InitialSettings.DriverFactory;
import PAGES.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class CommonUtilsMethods {
WebDriver driver;
WebDriverWait wait;
public CommonUtilsMethods(){
    this.driver = DriverFactory.getDriver();
    this.wait= DriverFactory.getWait();
}
    public static String getEmailWithTimeStamp(){
        Date date = new Date();
        return  "motor"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";

    }
    // Waits are Copied from BasePage just to have them here also
    public WebElement waitUntilClickable(By locator){
        WebElement webElement=null;
        try {
            webElement  = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Throwable e){
            e.printStackTrace();
        }
        return webElement;
    }
    public WebElement waitUntilVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   public Alert waitForAlert(){
       Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       return alert;
   }
   public void acceptAlert(){
       Alert alert = waitForAlert();
        alert.accept();
   }
   public void dismissAlert(){
       Alert alert = waitForAlert();
       alert.dismiss();
   }
    public void selectOptionInDropDown(By locator,String dropDownOption){
    WebElement webElement = waitUntilVisible(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }
    public void mouseHoverAndClick(By locator){
    WebElement webElement = waitUntilVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }
}
