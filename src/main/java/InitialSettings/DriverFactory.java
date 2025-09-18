package InitialSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
  public static   WebDriver driver;
    private static WebDriverWait wait;

    public static void initializeBrowser(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                 driver = new ChromeDriver();

                break;
            case "firefox":
                 driver = new FirefoxDriver();
                 break;
            case "edge":
                WebDriverManager.edgedriver().driverVersion("140.0.0.0").setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unknown driver  "+ browser);

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public static WebDriverWait getWait(){
        return wait;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
