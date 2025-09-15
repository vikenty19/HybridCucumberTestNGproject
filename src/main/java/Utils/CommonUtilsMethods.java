package Utils;

import java.util.Date;

public class CommonUtilsMethods {
    public static String getEmailWithTimeStamp(){
        Date date = new Date();
        return  "motor"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";

    }
}
