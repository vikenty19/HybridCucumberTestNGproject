package PAGES;
import InitialSettings.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
    }
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
    public void enterTextIntoField(By locator,String text){
        WebElement webElement=waitUntilVisible(locator);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);

    }
    public void clickOnElement(By locator){
        waitUntilClickable(locator).click();
    }
    public String getTextFromElement(By locator){
      WebElement element=  waitUntilVisible(locator);
      return element.getText();
    }

}
