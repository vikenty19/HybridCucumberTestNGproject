package PAGES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchPage extends BasePage{

    By searchResultLocator =By.xpath("//div/h4/a");
    By invalidResultLocator =By
            .xpath("//input[@id='button-search']/following-sibling::p");
    public String searchValidItemResultText(){
       return getTextFromElement(searchResultLocator);
    }
    public String searchInvalidItemResultText(){
        return getTextFromElement(invalidResultLocator);
    }
}
