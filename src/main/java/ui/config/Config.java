package ui.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    private static String goUIDataFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ui\\ui_data.properties";
    private static Properties properties = null;
    private static Properties ui_data = null;

    // Load properties from Config properties
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

    //Get property from Properties
    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }

    // Load Properties from UI Data properties files
    public static String getDataProperty(String key) {
        ui_data = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(goUIDataFilePath);
            ui_data.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ui_data == null)
            loadProperties();
        String p = System.getProperty(key);
        return p != null ? p : ui_data.getProperty(key);
    }


}
