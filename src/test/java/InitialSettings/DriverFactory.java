package InitialSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  public static   WebDriver driver;

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


    }
    public static WebDriver getDriver(){
        return driver;
    }
}
