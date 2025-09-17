package StepDefinitions;

import InitialSettings.DriverFactory;
import PAGES.BasePage;
import PAGES.HomePage;
import PAGES.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchStepDef extends BasePage {
    private HomePage homePage;
    private SearchPage searchPage;

    @Given("User opens application URL")
    public void user_opens_application_url() {
    //    DriverFactory.getDriver();
     //   DriverFactory.getWait(); all implements in the abstract BasePage


    }

    @When("User search for a product {string}")
    public void user_search_for_a_product(String string) {
        homePage = new HomePage();
        homePage.enterItemInSearchField(string);

    }

    @When("User search for an invalid product {string}")
    public void userSearchForAnInvalidProduct(String invalidItem) {
        homePage = new HomePage();
        homePage.enterItemInSearchField(invalidItem);
    }

    @When("User click on Search button")
    public void user_click_on_search_button() {
        homePage = new HomePage();
        searchPage = homePage.clickOnSearchBtn();
    }

    @Then("User should see a valid product in the search results")
    public void user_should_see_a_valid_product_in_the_search_results() {
          Assert.assertTrue(searchPage.searchValidItemResultText().contains("HP"));

    }

    @Then("User should get an warning message about no product matching")
    public void user_should_get_an_warning_message_about_no_product_matching() {
            Assert.assertEquals(searchPage.searchInvalidItemResultText(),
                "There is no product that matches the search criteria.");

    }

    @When("User doesn't enter any product name in the search field")
    public void user_doesn_t_enter_any_product_name_in_the_search_field() {
        //Intentionally left empty


    }


}
