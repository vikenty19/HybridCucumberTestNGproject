package StepDefinitions;

import InitialSettings.DriverFactory;
import PAGES.HomePage;
import PAGES.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Date;


public class LoginStepDef {

WebDriver driver;
WebDriverWait wait;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
       driver= DriverFactory.getDriver();
       wait = DriverFactory.getWait();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLoginBtn();
    }

    @When("User has entered the valid email address {string} into email fields")
    public void user_has_entered_the_valid_email_address_into_email_fields(String string) {
       LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(string);

    }

    @When("User has entered the valid password {string} into password field")
    public void user_has_entered_the_valid_password_into_password_field(String string) {
       LoginPage  loginPage = new LoginPage(driver);
        loginPage.enterValidPassword(string);
        }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
      LoginPage  loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();

    }

    @Then("User Should been login successfully")
    public void user_should_been_login_successfully() {
       LoginPage  loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isAccountInfoIsDisplayed());

    }

    @When("User has entered the invalid email address  into email fields")
    public void user_has_entered_the_invalid_email_address_into_email_fields() {
       LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
    }

    @When("User has entered the invalid password {string} into password field")
    public void user_has_entered_the_invalid_password_into_password_field(String invalidPassword) {
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterInvalidPassword(invalidPassword);
    }

    @Then("User Should get an proper warning message about invalid credentials")
    public void user_should_get_an_proper_warning_message_about_invalid_credentials() {
     LoginPage loginPage = new LoginPage(driver);
     Assert.assertEquals(loginPage.getWarningMessageText(),
             "Warning: No match for E-Mail Address and/or Password.");
    }

    @When("User doesn't entered email address  into email fields")
    public void user_doesn_t_entered_email_address_into_email_fields() {
        LoginPage loginPage = new LoginPage(driver);
       loginPage.enterEmail("");


    }

    @When("User doesn't entered  password  into password field")
    public void user_doesn_t_entered_password_into_password_field() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidPassword("");
    }

}
