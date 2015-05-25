package com.jacmobile.productlookup.network.model;

public class WalmartItem {
    private int itemId;
    private int parentItemId;
    private String name;
    private double salePrice;
    private String upc;
    private String categoryPath;
    private String shortDescription;
    private String longDescription;
    private String thumbnailImage;
    private String productTrackingUrl;
    private double standardShipRate;
    private boolean marketplace;
    private String modelNumber;
    private String productUrl;
    private String customerRating;
    private int numReviews;
    private String customerRatingImage;
    private String categoryNode;
    private boolean bundle;
    private String addToCartUrl;
    private String affiliateAddToCartUrl;
    private boolean availableOnline;

    @Override public String toString()
    {
        return "WalmartItem{" +
                "itemId=" + itemId +
                ", parentItemId=" + parentItemId +
                ", name='" + name + '\'' +
                ", salePrice=" + salePrice +
                ", upc='" + upc + '\'' +
                ", categoryPath='" + categoryPath + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", thumbnailImage='" + thumbnailImage + '\'' +
                ", productTrackingUrl='" + productTrackingUrl + '\'' +
                ", standardShipRate=" + standardShipRate +
                ", marketplace=" + marketplace +
                ", modelNumber='" + modelNumber + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", customerRating='" + customerRating + '\'' +
                ", numReviews=" + numReviews +
                ", customerRatingImage='" + customerRatingImage + '\'' +
                ", categoryNode='" + categoryNode + '\'' +
                ", bundle=" + bundle +
                ", addToCartUrl='" + addToCartUrl + '\'' +
                ", affiliateAddToCartUrl='" + affiliateAddToCartUrl + '\'' +
                ", availableOnline=" + availableOnline +
                '}';
    }

    /**
     *
     * @return
     * The itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     *
     * @param itemId
     * The itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @return
     * The parentItemId
     */
    public int getParentItemId() {
        return parentItemId;
    }

    /**
     *
     * @param parentItemId
     * The parentItemId
     */
    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The salePrice
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     *
     * @param salePrice
     * The salePrice
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     *
     * @return
     * The upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     *
     * @param upc
     * The upc
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     *
     * @return
     * The categoryPath
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     *
     * @param categoryPath
     * The categoryPath
     */
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    /**
     *
     * @return
     * The shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     *
     * @param shortDescription
     * The shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     *
     * @return
     * The longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     *
     * @param longDescription
     * The longDescription
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     *
     * @return
     * The thumbnailImage
     */
    public String getThumbnailImage() {
        return thumbnailImage;
    }

    /**
     *
     * @param thumbnailImage
     * The thumbnailImage
     */
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    /**
     *
     * @return
     * The productTrackingUrl
     */
    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    /**
     *
     * @param productTrackingUrl
     * The productTrackingUrl
     */
    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    /**
     *
     * @return
     * The standardShipRate
     */
    public double getStandardShipRate() {
        return standardShipRate;
    }

    /**
     *
     * @param standardShipRate
     * The standardShipRate
     */
    public void setStandardShipRate(double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    /**
     *
     * @return
     * The marketplace
     */
    public boolean isMarketplace() {
        return marketplace;
    }

    /**
     *
     * @param marketplace
     * The marketplace
     */
    public void setMarketplace(boolean marketplace) {
        this.marketplace = marketplace;
    }

    /**
     *
     * @return
     * The modelNumber
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     *
     * @param modelNumber
     * The modelNumber
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     *
     * @return
     * The productUrl
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     *
     * @param productUrl
     * The productUrl
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    /**
     *
     * @return
     * The customerRating
     */
    public String getCustomerRating() {
        return customerRating;
    }

    /**
     *
     * @param customerRating
     * The customerRating
     */
    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    /**
     *
     * @return
     * The numReviews
     */
    public int getNumReviews() {
        return numReviews;
    }

    /**
     *
     * @param numReviews
     * The numReviews
     */
    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    /**
     *
     * @return
     * The customerRatingImage
     */
    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    /**
     *
     * @param customerRatingImage
     * The customerRatingImage
     */
    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    /**
     *
     * @return
     * The categoryNode
     */
    public String getCategoryNode() {
        return categoryNode;
    }

    /**
     *
     * @param categoryNode
     * The categoryNode
     */
    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    /**
     *
     * @return
     * The bundle
     */
    public boolean isBundle() {
        return bundle;
    }

    /**
     *
     * @param bundle
     * The bundle
     */
    public void setBundle(boolean bundle) {
        this.bundle = bundle;
    }

    /**
     *
     * @return
     * The addToCartUrl
     */
    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    /**
     *
     * @param addToCartUrl
     * The addToCartUrl
     */
    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    /**
     *
     * @return
     * The affiliateAddToCartUrl
     */
    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    /**
     *
     * @param affiliateAddToCartUrl
     * The affiliateAddToCartUrl
     */
    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    /**
     *
     * @return
     * The availableOnline
     */
    public boolean isAvailableOnline() {
        return availableOnline;
    }

    /**
     *
     * @param availableOnline
     * The availableOnline
     */
    public void setAvailableOnline(boolean availableOnline) {
        this.availableOnline = availableOnline;
    }
}
