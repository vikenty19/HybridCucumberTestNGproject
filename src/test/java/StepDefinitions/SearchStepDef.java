package StepDefinitions;

import InitialSettings.DriverFactory;
import PAGES.HomePage;
import PAGES.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchStepDef {
    WebDriver gDriver;//gDriver just to understand deeper a driver transition
    WebDriverWait wait;
    @Given("User opens application URL")
    public void user_opens_application_url() {
        gDriver= DriverFactory.getDriver();
        wait = DriverFactory.getWait();


    }

    @When("User search for a product {string}")
    public void user_search_for_a_product(String string) {
        HomePage homePage= new HomePage(gDriver);
       homePage.enterItemInSearchField(string);

    }
    @When("User search for an invalid product {string}")
    public void userSearchForAnInvalidProduct(String invalidItem) {
        HomePage homePage= new HomePage(gDriver);
        homePage.enterItemInSearchField(invalidItem);
    }

    @When("User click on Search button")
    public void user_click_on_search_button() {
        HomePage homePage= new HomePage(gDriver);
    homePage.clickOnSearchBtn();
    }

    @Then("User should see a valid product in the search results")
    public void user_should_see_a_valid_product_in_the_search_results() {
         SearchPage searchPage = new SearchPage(gDriver);
        Assert.assertTrue(searchPage.searchValidItemResultText().contains("HP"));

    }

    @Then("User should get an warning message about no product matching")
    public void user_should_get_an_warning_message_about_no_product_matching() {
        SearchPage searchPage = new SearchPage(gDriver);
        Assert.assertEquals(searchPage.searchInvalidItemResultText(),
                "There is no product that matches the search criteria.");

    }

    @When("User doesn't enter any product name in the search field")
    public void user_doesn_t_enter_any_product_name_in_the_search_field() {
        //Intentionally left empty


    }


}
