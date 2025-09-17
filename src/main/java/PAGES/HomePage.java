package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    By accountLocator = By.cssSelector(".fa-user");
    By loginLocator = By.linkText("Login");
    By registerLocator = By.linkText("Register");
    By searchFieldLocator= By.name("search");
    By searchBtnLocator =By.cssSelector(".fa-search");

    public void clickOnMyAccount(){
        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(accountLocator));
        account.click();
    }
    public LoginPage clickOnLoginBtn(){
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginLocator));
        login.click();
        return new LoginPage();
    }
    public RegisterPage clickOnRegisterBtn(){
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(registerLocator));
        register.click();
        return new RegisterPage();
    }
    public void enterItemInSearchField(String item){

        driver.findElement(searchFieldLocator).sendKeys(item);
    }

    public SearchPage clickOnSearchBtn(){
        driver.findElement(searchBtnLocator).click();
        return new SearchPage();

    }

}
