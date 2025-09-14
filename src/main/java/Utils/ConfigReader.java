package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties readProperties() {

        Properties prop = new Properties();
        File file = new File(System.getProperty("user.dir"+"/src/test/resources/ConfigProperties"));
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      return prop;
    }
}
