package StepDefinitions;

import InitialSettings.DriverFactory;
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

import java.util.Date;
import java.util.Map;

public class RegisterStepDef {
    WebDriver driver;
    WebDriverWait wait;
    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
       driver= DriverFactory.getDriver();
       wait=DriverFactory.getWait();
        WebElement accountLocator = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-user")));
        accountLocator.click();
        driver.findElement(By.linkText("Register")).click();



    }

    @When("User doesn't enter  any details")
    public void user_doesn_t_enter_any_details() {
        //Intentionally keep blank

    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @Then("User should see a proper messages in all mandatory fields")
    public void user_should_see_a_proper_messages_in_all_mandatory_fields() {
        WebElement message =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
        Assert.assertEquals(message.getText(),"Warning: You must agree to the Privacy Policy!");
     WebElement fNameWarning = wait
             .until(ExpectedConditions
                     .visibilityOfElementLocated
                             (By.xpath("//input[@id='input-firstname']/following-sibling::div")));
     Assert.assertEquals(fNameWarning.getText(),"First Name must be between 1 and 32 characters!");
        Assert.assertEquals(message.getText(),"Warning: You must agree to the Privacy Policy!");
        WebElement lNameWarning = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//input[@id='input-lastname']/following-sibling::div")));
        Assert.assertEquals(lNameWarning.getText(),"Last Name must be between 1 and 32 characters!");
        WebElement emailWarning = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//input[@id='input-email']/following-sibling::div")));
        Assert.assertEquals(emailWarning.getText(),"E-Mail Address does not appear to be valid!");
       // need to implement phone message, password
    }

    @When("User enters the details into below fields")
    public void userEntersTheDetailsIntoBelowFields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class,String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(map.get("FirstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(map.get("LastName"));
        driver.findElement(By.id("input-email")).sendKeys(map.get("Email"));
     //   driver.findElement(By.id("input-email")).sendKeys(emailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(map.get("Telephone"));
        driver.findElement(By.id("input-password")).sendKeys(map.get("Password"));
        driver.findElement(By.id("input-confirm")).sendKeys(map.get("Password"));


    }

    @Then("User should see proper warning message about duplicate email")
    public void userShouldSeeProperWarningMessageAboutDuplicateEmail() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
        Assert.assertEquals(message.getText(),"Warning: E-Mail Address is already registered!");
    }


    @And("User select Yes the Privacy Policy")
    public void userSelectYesThePrivacyPolicy() {
        driver.findElement(By.name("agree")).click();
    }

  @Then("User  should see that the User Account has successfully been created")
    public void userShouldSeeThatTheUserAccountHasSuccessfullyBeenCreated() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content>h1")));
      Assert.assertEquals(message.getText(),"Your Account Has Been Created!");
    }


    @And("User select Yes for the newsletter")
    public void userSelectYesForTheNewsletter() {
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
    }
    public String emailWithTimeStamp(){
        Date date = new Date();
        return "motor"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
    }

    @And("User enter new email")
    public void userEnterNewEmail() {
        driver.findElement(By.id("input-email")).sendKeys(emailWithTimeStamp());
    }
}
