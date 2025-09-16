package PAGES;

import Utils.CommonUtilsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends HomePage{
    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By searchResultLocator =By.xpath("//div/h4/a");
    By invalidResultLocator =By
            .xpath("//input[@id='button-search']/following-sibling::p");
    public String searchValidItemResultText(){
        WebElement result = CommonUtilsMethods.waitUntilClickable(searchResultLocator);
        return result.getText();
    }
    public String searchInvalidItemResultText(){
        WebElement noItem =CommonUtilsMethods.waitUntilClickable(invalidResultLocator);
        return  noItem.getText();
    }
}
