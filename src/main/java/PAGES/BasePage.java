package PAGES;
import InitialSettings.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
    }
}
