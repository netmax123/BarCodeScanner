
package com.dvinasystems.barcodescanner.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("category_ids")
    @Expose
    private List<Object> categoryIds = null;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<Object> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Object> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

}
