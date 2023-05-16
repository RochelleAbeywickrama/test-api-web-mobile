package ui.common;

import ui.config.Config;

public class Constants {

    private Constants() {
    }

    //Data - web test
    public static final String APP_BASE_URL = Config.getProperty("web.base.url");
    public static final String WEB_EXECUTION = Config.getProperty("web.execution");
    public static final String HOME_PAGE_TITLE = Config.getDataProperty("homePageTitle");
    public static final String SEARCH_TERM = Config.getDataProperty("searchTerm");
    public static final String RESULTS_PAGE_TITLE = Config.getDataProperty("productListPageTitle");
    public static final String CART_PAGE_TITLE = Config.getDataProperty("cartPageTitle");
    public static final String ERROR_NO_PRODUCT_ADDED = Config.getDataProperty("unsucessfulProductAddError");
    public static final String ERROR_NO_PRODUCT_IN_CART = Config.getDataProperty("noItemsInCartError");

    // Data - Mobile
    public static final String APPIUM_SERVER_URL = Config.getProperty("appium.server.url");
    public static final String MOBILE_EXECUTION = Config.getProperty("mobile.execution");
    public static final String PLATFORM_NAME = Config.getProperty("platformName");
    public static final String DEVICE_NAME = Config.getProperty("deviceName");
    public static final String UDID = Config.getProperty("udid");
    public static final String PLATFORM_VERSION = Config.getProperty("platformVersion");
    public static final String BROWSER_NAME = Config.getProperty("browserName");
    public static final String AUTOMATION_NAME = Config.getProperty("automationName");
    public static final String NEW_COMMAND_TIMEOUT = Config.getProperty("newCommandTimeout");
    public static final String SUPPORTS_JAVASCRIPT = Config.getProperty("javascriptEnabled");

}
