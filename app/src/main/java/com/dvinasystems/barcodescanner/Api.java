/*
Define POST method for Retrofit
Created by Maxim G. on December 11, 2018
*/

package com.dvinasystems.barcodescanner;


import com.dvinasystems.barcodescanner.json.ProductData;
import com.dvinasystems.barcodescanner.json.ProductResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Api {

    @POST
    Call<ProductResult> getStringScalar(@Body ProductData body, @Url String url);
}
