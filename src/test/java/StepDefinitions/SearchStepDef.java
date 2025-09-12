package StepDefinitions;

import io.cucumber.java.en.*;

public class SearchStepDef {
    @Given("User opens application URL")
    public void user_opens_application_url() {

    }

    @When("User search for a product {string}")
    public void user_search_for_a_product(String string) {

    }

    @When("User click on Search button")
    public void user_click_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should see a valid product in the search results")
    public void user_should_see_a_valid_product_in_the_search_results() {

    }

    @Then("User should get an warning message about no product matching")
    public void user_should_get_an_warning_message_about_no_product_matching() {

    }

    @When("User doesn't enter any product name in the search field")
    public void user_doesn_t_enter_any_product_name_in_the_search_field() {

    }

}
