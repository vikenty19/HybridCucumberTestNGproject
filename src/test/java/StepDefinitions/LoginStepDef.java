package StepDefinitions;

import InitialSettings.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Date;


public class LoginStepDef {

WebDriver driver;
WebDriverWait wait;
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
       driver= DriverFactory.getDriver();
       wait = DriverFactory.getWait();
        WebElement accountLocator = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-user")));
        accountLocator.click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("User has entered the valid email address {string} into email fields")
    public void user_has_entered_the_valid_email_address_into_email_fields(String string) {
        WebElement emailLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
        emailLocator.sendKeys(string);

    }

    @When("User has entered the valid password {string} into password field")
    public void user_has_entered_the_valid_password_into_password_field(String string) {
        WebElement passwordLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
        passwordLocator.sendKeys(string);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.cssSelector("[type='submit']")).click();

    }

    @Then("User Should been login successfully")
    public void user_should_been_login_successfully() {
        WebElement accountCreatedLocator = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content>h2")));
        Assert.assertTrue(accountCreatedLocator.isDisplayed());

    }

    @When("User has entered the invalid email address  into email fields")
    public void user_has_entered_the_invalid_email_address_into_email_fields() {
        WebElement emailLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));

        emailLocator.sendKeys(getEmailWithTimeStamp());
    }

    @When("User has entered the invalid password {string} into password field")
    public void user_has_entered_the_invalid_password_into_password_field(String invalidPassword) {
        WebElement passwordLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
        passwordLocator.sendKeys(invalidPassword);
    }

    @Then("User Should get an proper warning message about invalid credentials")
    public void user_should_get_an_proper_warning_message_about_invalid_credentials() {
        WebElement warnMessageLocator = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".alert")));
        Assert.assertEquals(warnMessageLocator.getText(),"Warning: No match for E-Mail Address and/or Password.");
    }

    @When("User doesn't entered email address  into email fields")
    public void user_doesn_t_entered_email_address_into_email_fields() {
        WebElement emailLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
        emailLocator.sendKeys("");

    }

    @When("User doesn't entered  password  into password field")
    public void user_doesn_t_entered_password_into_password_field() {
        WebElement passwordLocator =  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
        passwordLocator.sendKeys("");
    }
    private String getEmailWithTimeStamp(){
        Date date = new Date();
        return  "motor"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";

    }
}
