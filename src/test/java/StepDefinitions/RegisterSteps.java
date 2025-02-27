package StepDefinitions;

import com.tutorialsninja.base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterSteps extends Base{
    @Given("I launch the app")
    public void iLaunchTheApp() {
        Base base = new Base();
        base.setBrowserAndOpenUrl();
        System.out.println("Result");
    }

    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails() {
    }

    @And("I check-in the Privacy Policy")
    public void iCheckInThePrivacyPolicy() {
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
    }

    @Then("I should see that the User Account has successfully been created")
    public void iShouldSeeThatTheUserAccountHasSuccessfullyBeenCreated() {
    }
}
