package com.jacmobile.productlookup.network.model;

import java.util.ArrayList;
import java.util.List;

public class WalmartQuery
{
    private String query;
    private String sort;
    private String responseGroup;
    private int totalResults;
    private int start;
    private int numItems;
    private List<WalmartItem> items = new ArrayList<>();

    /**
     *
     * @return
     * The query
     */
    public String getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     *
     * @return
     * The sort
     */
    public String getSort() {
        return sort;
    }

    /**
     *
     * @param sort
     * The sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     *
     * @return
     * The responseGroup
     */
    public String getResponseGroup() {
        return responseGroup;
    }

    /**
     *
     * @param responseGroup
     * The responseGroup
     */
    public void setResponseGroup(String responseGroup) {
        this.responseGroup = responseGroup;
    }

    /**
     *
     * @return
     * The totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The totalResults
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The start
     */
    public int getStart() {
        return start;
    }

    /**
     *
     * @param start
     * The start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     *
     * @return
     * The numItems
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     *
     * @param numItems
     * The numItems
     */
    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    /**
     *
     * @return
     * The items
     */
    public List<WalmartItem> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<WalmartItem> items) {
        this.items = items;
    }
}