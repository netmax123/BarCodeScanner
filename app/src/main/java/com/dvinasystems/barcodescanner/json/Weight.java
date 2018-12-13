
package com.dvinasystems.barcodescanner.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weight {

    @SerializedName("val")
    @Expose
    private Double val;
    @SerializedName("um")
    @Expose
    private String um;

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

}
