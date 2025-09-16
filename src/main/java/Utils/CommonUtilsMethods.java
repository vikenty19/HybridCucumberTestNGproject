package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class CommonUtilsMethods {

    public static String getEmailWithTimeStamp(){
        Date date = new Date();
        return  "motor"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";

    }

}
