package api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TreeMap;

public class Config {

    private static String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    private static String goRestDataFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\api\\api_data.properties";
    private static Properties properties = null;
    private static Properties api_data = null;

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

    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }

    public static String getDataProperty(String key) {
        api_data = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(goRestDataFilePath);
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
