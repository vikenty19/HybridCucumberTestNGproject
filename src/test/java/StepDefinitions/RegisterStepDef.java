package StepDefinitions;

import InitialSettings.DriverFactory;
import PAGES.HomePage;
import PAGES.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;

public class RegisterStepDef {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        driver = DriverFactory.getDriver();
        wait = DriverFactory.getWait();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnRegisterBtn();
       }

    @When("User doesn't enter  any details")
    public void user_doesn_t_enter_any_details() {
        //Intentionally keep blank

    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
       RegisterPage registerPage = new RegisterPage(driver);
       registerPage.clickOnContinueBtn();

    }

    @Then("User should see a proper messages in all mandatory fields")
    public void user_should_see_a_proper_messages_in_all_mandatory_fields() {
        RegisterPage registerPage =new RegisterPage(driver);
        Assert.assertEquals(registerPage.getWarningMessageText(), "Warning: You must agree to the Privacy Policy!");
        WebElement fNameWarning = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//input[@id='input-firstname']/following-sibling::div")));
        Assert.assertEquals(fNameWarning.getText(), "First Name must be between 1 and 32 characters!");
    //    Assert.assertEquals(message.getText(), "Warning: You must agree to the Privacy Policy!");
        WebElement lNameWarning = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//input[@id='input-lastname']/following-sibling::div")));
        Assert.assertEquals(lNameWarning.getText(), "Last Name must be between 1 and 32 characters!");
        WebElement emailWarning = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//input[@id='input-email']/following-sibling::div")));
        Assert.assertEquals(emailWarning.getText(), "E-Mail Address does not appear to be valid!");
        // need to implement phone message, password
    }

    @When("User enters the details into below fields")
    public void userEntersTheDetailsIntoBelowFields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(map.get("FirstName"));
        registerPage.enterLastName(map.get("LastName"));
        registerPage.enterUniqueEmail();
        registerPage.enterPhoneNumber(map.get("Telephone"));
        registerPage.createPassword(map.get("Password"));
        registerPage.confirmPassword(map.get("Password"));
    }

    @Then("User should see proper warning message about duplicate email")
    public void userShouldSeeProperWarningMessageAboutDuplicateEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getWarningMessageText(),
                "Warning: E-Mail Address is already registered!");
    }


    @And("User select Yes the Privacy Policy")
    public void userSelectYesThePrivacyPolicy() {
      RegisterPage registerPage =new RegisterPage(driver);
      registerPage.selectYesPrivacyPolicy();
    }

    @Then("User  should see that the User Account has successfully been created")
    public void userShouldSeeThatTheUserAccountHasSuccessfullyBeenCreated() {
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.accountCreatedText(), "Your Account Has Been Created!");
    }


    @And("User select Yes for the newsletter")
    public void userSelectYesForTheNewsletter() {
        RegisterPage registerPage = new RegisterPage(driver);
       registerPage.selectYesInNewsLetterBox();
    }


    @When("User enters the details with duplicate email into below fields")
    public void userEntersTheDetailsWithDuplicateEmailIntoBelowFields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(map.get("FirstName"));
        registerPage.enterLastName(map.get("LastName"));
        registerPage.enterDuplicateEmail(map.get("Email"));
        registerPage.enterPhoneNumber(map.get("Telephone"));
        registerPage.createPassword(map.get("Password"));
        registerPage.confirmPassword(map.get("Password"));

    }
}
