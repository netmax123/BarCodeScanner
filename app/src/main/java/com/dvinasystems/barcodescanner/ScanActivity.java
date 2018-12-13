/*
Logic for ZXing for a bar code scanner, Retrofit for network requests and Glide for operations with images
Created by Maxim G. on December 12, 2018
*/

package com.dvinasystems.barcodescanner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.dvinasystems.barcodescanner.json.ProductData;
import com.dvinasystems.barcodescanner.json.ProductResult;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private static final String URL = "https://img.napolke.ru/image/get?uuid=";
    private static final String TAG = "BarCodeScanner";

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // making sure camera is available
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
        }

        // initialize the scanner view and set it as a content view
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        // register view to handle resu;ts
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        // Value of scan code
        Log.v(TAG, rawResult.getText());
        // Value of scan format
        Log.v(TAG, rawResult.getBarcodeFormat().toString());

        // send bar code value to retrofit
        request(rawResult.toString());

        onBackPressed();

        // resume scanning
        //mScannerView.resumeCameraPreview(this);


    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }


    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
    }

    public void request(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catalog.napolke.ru/search/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api service = retrofit.create(Api.class);
        List<String> regions = new ArrayList<>();
        regions.add("0c5b2444-70a0-4932-980c-b4dc0d3f02b5");
        regions.add(null);
        regions.add(null);
        Call<ProductResult> call = service.getStringScalar(new ProductData(id, regions), "https://catalog.napolke.ru/search/catalog");
        call.enqueue(new Callback<ProductResult>() {
            @Override
            public void onResponse(Call<ProductResult> call, Response<ProductResult> response) {
                Log.v(TAG, "Retrofit OK");

                ProductResult body = response.body();

                if (body.getData().isEmpty()) {
                    Log.v(TAG, "no product found");
                    MainActivity.scanResult.setText("Продукт не найден в базе данных!\nProduct is not found in the database!");
                } else {

                    if (body.getData().get(0).getName().isEmpty())
                        Log.v(TAG, "Product name is not available");
                    else {
                        Log.v(TAG, body.getData().get(0).getName());
                        // Display name of the product
                        MainActivity.scanResult.setText(body.getData().get(0).getName());
                        MainActivity.barcodeValue.setText(body.getData().get(0).getName());
                    }

                    if (body.getData().get(0).getImages().isEmpty()) {
                        Log.v(TAG, "Product photo is not available");
                    } else {
                        {
                            Log.v(TAG, body.getData().get(0).getImages().get(0));
                            // Display image of a product
                            Glide.with(getApplicationContext()).load(URL + body.getData().get(0).getImages().get(0)).into(MainActivity.productImage);
                            MainActivity.imageId.setText(body.getData().get(0).getImages().get(0));

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResult> call, Throwable t) {
                Log.v(TAG, "Retrofit FAIL");
            }
        });

    }

}

