package api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    private static String goApiDataFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\api\\api_data.properties";
    private static Properties properties = null;
    private static Properties api_data = null;

    // Load Properties from Config properties
    public static void loadProperties() {
        properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(configFilePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Property from properties
    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }

    // Load Properties from API Data properties files
    public static String getDataProperty(String key) {
        api_data = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(goApiDataFilePath);
            api_data.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (api_data == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : api_data.getProperty(key);
    }


}
