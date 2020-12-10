package com.example.androidinterview.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("id")
    private Integer id;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("isClose")
    private Boolean isClose;
    @SerializedName("closeLabel")
    private String closeLabel;
    @SerializedName("productName")
    private String productName;
    @SerializedName("productDesc")
    private String productDesc;
    @SerializedName("star")
    private Double star;
    @SerializedName("distance")
    private String distance;
    @SerializedName("promoDesc")
    private String promoDesc;
    @SerializedName("outletAround")
    private Integer outletAround;
    @SerializedName("outletDesc")
    private Integer outletDesc;

    public DataModel(Integer id, String imageUrl, Boolean isClose, String closeLabel, String productName, String productDesc,Double star, String distance, String promoDesc, Integer outletAround, Integer outletDesc) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.isClose = isClose;
        this.closeLabel = closeLabel;
        this.productName = productName;
        this.productDesc = productDesc;
        this.star = star;
        this.distance = distance;
        this.promoDesc = promoDesc;
        this.outletAround = outletAround;
        this.outletDesc = outletDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsClose() {
        return isClose;
    }

    public void setIsClose(Boolean isClose) {
        this.isClose = isClose;
    }

    public String getCloseLabel() {
        return closeLabel;
    }

    public void setCloseLabel(String closeLabel) {
        this.closeLabel = closeLabel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPromoDesc() {
        return promoDesc;
    }

    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }

    public Integer getOutletAround() {
        return outletAround;
    }

    public void setOutletAround(Integer outletAround) {
        this.outletAround = outletAround;
    }

    public Integer getOutletDesc() {
        return outletDesc;
    }

    public void setOutletDesc(Integer outletDesc) {
        this.outletDesc = outletDesc;
    }

}
