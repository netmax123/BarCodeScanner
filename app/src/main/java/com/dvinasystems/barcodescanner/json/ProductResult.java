
package com.dvinasystems.barcodescanner.json;

import java.util.List;

import com.dvinasystems.barcodescanner.json.Datum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductResult {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
