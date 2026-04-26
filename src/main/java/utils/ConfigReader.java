package utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();
            InputStream is = ConfigReader.class
        .getClassLoader()
        .getResourceAsStream("config.properties");
            prop.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
