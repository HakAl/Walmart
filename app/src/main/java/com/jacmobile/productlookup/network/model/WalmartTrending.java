package com.jacmobile.productlookup.network.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalmartTrending {

    private int time;
    private List<WalmartTrendingItem> items = new ArrayList<>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The time
     */
    public int getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The items
     */
    public List<WalmartTrendingItem> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<WalmartTrendingItem> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}