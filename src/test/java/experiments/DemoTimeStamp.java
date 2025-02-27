package experiments;

import java.util.Date;

public class DemoTimeStamp {
    public static void main(String[] args) {
       Date date = new Date();
        System.out.println(date);
        String addedTimeStamp = date.toString().replace(":","_").substring(11,19);
        System.out.println(addedTimeStamp);

    }


    }



