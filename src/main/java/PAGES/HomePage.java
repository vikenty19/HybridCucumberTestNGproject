package PAGES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class HomePage extends BasePage {

    By accountLocator = By.cssSelector(".fa-user");
    By loginLocator = By.linkText("Login");
    By registerLocator = By.linkText("Register");
    By searchFieldLocator= By.name("search");
    By searchBtnLocator =By.cssSelector(".fa-search");

    public void clickOnMyAccount(){
        WebElement account = waitUntilClickable(accountLocator);
        account.click();
    }
    public LoginPage clickOnLoginBtn(){
        WebElement login = waitUntilClickable(loginLocator);
        login.click();
        return new LoginPage();
    }
    public RegisterPage clickOnRegisterBtn(){
        WebElement register = waitUntilClickable(registerLocator);
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
