package PAGES;
import org.openqa.selenium.By;




public class HomePage extends BasePage {

    By accountLocator = By.cssSelector(".fa-user");
    By loginLocator = By.linkText("Login");
    By registerLocator = By.linkText("Register");
    By searchFieldLocator= By.name("search");
    By searchBtnLocator =By.cssSelector(".fa-search");

    public void clickOnMyAccount(){
        clickOnElement(accountLocator);
    }
    public LoginPage clickOnLoginBtn(){
        clickOnElement(loginLocator);
        return new LoginPage();
    }
    public RegisterPage clickOnRegisterBtn(){
        clickOnElement(registerLocator);
        return new RegisterPage();
    }
    public void enterItemInSearchField(String item){
        enterTextIntoField(searchFieldLocator,item);
    }

    public SearchPage clickOnSearchBtn(){
        driver.findElement(searchBtnLocator).click();
        return new SearchPage();

    }

}
