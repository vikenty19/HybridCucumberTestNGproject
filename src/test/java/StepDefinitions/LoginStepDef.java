package StepDefinitions;

import PAGES.HomePage;
import PAGES.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class LoginStepDef {

 private LoginPage loginPage;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
   //    driver= DriverFactory.getDriver();
  //     wait = DriverFactory.getWait();
        HomePage homePage = new HomePage();
        homePage.clickOnMyAccount();
        loginPage=homePage.clickOnLoginBtn();
    }

    @When("User has entered the valid email address {string} into email fields")
    public void user_has_entered_the_valid_email_address_into_email_fields(String string) {
            loginPage.enterEmail(string);

    }

    @When("User has entered the valid password {string} into password field")
    public void user_has_entered_the_valid_password_into_password_field(String string) {
        loginPage.enterValidPassword(string);
        }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
          loginPage.clickSubmitBtn();

    }

    @Then("User Should been login successfully")
    public void user_should_been_login_successfully() {
          Assert.assertTrue(loginPage.isAccountInfoDisplayed());

    }

    @When("User has entered the invalid email address  into email fields")
    public void user_has_entered_the_invalid_email_address_into_email_fields() {
         loginPage.enterInvalidEmail();
    }

    @When("User has entered the invalid password {string} into password field")
    public void user_has_entered_the_invalid_password_into_password_field(String invalidPassword) {
            loginPage.enterInvalidPassword(invalidPassword);
    }

    @Then("User Should get an proper warning message about invalid credentials")
    public void user_should_get_an_proper_warning_message_about_invalid_credentials() {
      Assert.assertEquals(loginPage.getWarningMessageText(),
             "Warning: No match for E-Mail Address and/or Password.");
    }

    @When("User doesn't entered email address  into email fields")
    public void user_doesn_t_entered_email_address_into_email_fields() {
       loginPage.enterEmail("");


    }

    @When("User doesn't entered  password  into password field")
    public void user_doesn_t_entered_password_into_password_field() {
         loginPage.enterValidPassword("");
    }

}
