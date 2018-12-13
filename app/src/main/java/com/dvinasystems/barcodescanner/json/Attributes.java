
package com.dvinasystems.barcodescanner.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("boxing")
    @Expose
    private String boxing;
    @SerializedName("weight")
    @Expose
    private Weight weight;

    public String getBoxing() {
        return boxing;
    }

    public void setBoxing(String boxing) {
        this.boxing = boxing;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

}
