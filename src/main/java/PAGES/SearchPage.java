package PAGES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchPage extends BasePage{

    By searchResultLocator =By.xpath("//div/h4/a");
    By invalidResultLocator =By
            .xpath("//input[@id='button-search']/following-sibling::p");
    public String searchValidItemResultText(){
        WebElement result =waitUntilClickable(searchResultLocator);
        return result.getText();
    }
    public String searchInvalidItemResultText(){
        WebElement noItem =waitUntilClickable(invalidResultLocator);
        return  noItem.getText();
    }
}
