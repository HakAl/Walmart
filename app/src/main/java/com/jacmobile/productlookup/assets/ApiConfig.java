package com.jacmobile.productlookup.assets;

/**
 * Created by alex on 5/24/15.
 */
public class ApiConfig {
    public static final String TAG = ApiConfig.class.getSimpleName();

    public static final String WALMART_API_BASE_URL = "http://api.walmartlabs.com/v1";

    public static final String WALMART_API_KEY = "p8rh8kdrt9f7tqpkvazj2j5z";
    public static final String WALMART_API_CONFIG = "&format=json&apiKey=" + WALMART_API_KEY;
    public static final String WALMART_PRODUCT_SEARCH_CONFIG = "/search?{apiKey}";
//    public static final String WALMART_PRODUCT_SEARCH_CONFIG = "/search?query={query}" + WALMART_API_CONFIG;
}
