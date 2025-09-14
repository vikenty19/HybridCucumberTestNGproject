package hooks;

import InitialSettings.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class MyHooks {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setUp(){
        Properties prop = ConfigReader.readProperties();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver= DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

