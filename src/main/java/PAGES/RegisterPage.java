package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends HomePage{
    private WebDriver driver;
    private WebDriverWait wait;
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstNameLocator = By.id("input-firstname");
    public void enterFirstName(String firstName){
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

}
