package com.dvinasystems.barcodescanner.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductData {

    @SerializedName("text")
    private String text;

    @SerializedName("region")
    private List<String> region;

    public ProductData(String text, List<String> region) {
        this.text = text;
        this.region = region;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }
}
