package InitialSettings;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    private static WebDriverWait wait;

    public static void initializeBrowser(String browser) {
        Properties prop = ConfigReader.readProperties();
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
            //    WebDriverManager.edgedriver().setup();

                 String edgePath = prop.getProperty("edge.driver.path");
                System.setProperty("webdriver.edge.driver", edgePath);
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unknown driver  " + browser);

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("PAGE_LOAD_TIME"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(prop.getProperty("EXPLICIT_WAIT_TIME"))));
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
