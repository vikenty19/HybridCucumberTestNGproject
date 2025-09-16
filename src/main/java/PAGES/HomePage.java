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
    By registerLocator = By.linkText("Register");
    By searchFieldLocator= By.name("search");
    By searchBtnLocator =By.cssSelector(".fa-search");

    public void clickOnMyAccount(){
        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(accountLocator));
        account.click();
    }
    public void clickOnLoginBtn(){
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginLocator));
        login.click();
    }
    public void clickOnRegisterBtn(){
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(registerLocator));
        register.click();
    }
    public void enterValidItemInSearchField(String item){

        driver.findElement(searchFieldLocator).sendKeys(item);
    }
    public void enterInvalidItemInSearchField(String invalidItem){
        driver.findElement(searchFieldLocator).sendKeys(invalidItem);
    }
    public void clickOnSearchBtn(){
        driver.findElement(searchBtnLocator).click();

    }

}
