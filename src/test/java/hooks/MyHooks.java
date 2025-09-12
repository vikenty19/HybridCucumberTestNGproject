package hooks;

import InitialSettings.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyHooks {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setUp(){
        DriverFactory.initializeBrowser("Chrome");
        driver= DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://tutorialsninja.com/demo/");


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

