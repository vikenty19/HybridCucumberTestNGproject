package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By accountLocator = By.cssSelector(".fa-user");
    By loginLocator = By.linkText("Login");


    public void clickOnMyAccount(){
        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(accountLocator));
        account.click();
    }
    public void clickOnLoginBtn(){
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginLocator));
        login.click();
    }

}
