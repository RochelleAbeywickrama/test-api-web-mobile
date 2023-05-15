package web.common;

import web.config.Config;

public class Constants {

    private Constants() {
    }

    //Data - web test
    public static final String APP_BASE_URL = Config.getProperty("web.base.url");
    public static final String HOME_PAGE_TITLE = Config.getDataProperty("homePageTitle");
    public static final String SEARCH_TERM = Config.getDataProperty("searchTerm");
    public static final String RESULTS_PAGE_TITLE = Config.getDataProperty("productListPageTitle");
    public static final String CART_PAGE_TITLE = Config.getDataProperty("cartPageTitle");
    public static final String ERROR_NO_PRODUCT_ADDED = Config.getDataProperty("unsucessfulProductAddError");
    public static final String ERROR_NO_PRODUCT_IN_CART = Config.getDataProperty("noItemsInCartError");

}
