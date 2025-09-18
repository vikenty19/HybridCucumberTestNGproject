package hooks;

import InitialSettings.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class MyHooks {
    WebDriver driver;
    @Before
    public void setUp(){
        Properties prop = ConfigReader.readProperties();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver= DriverFactory.getDriver();
        driver.get(prop.getProperty("url"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

