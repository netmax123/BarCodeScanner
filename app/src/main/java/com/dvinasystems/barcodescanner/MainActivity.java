/*
Created by Maxim G. on December 11, 2018
*/

package com.dvinasystems.barcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView scanResult;
    private static Button scanButton;
    public static ImageView productImage;
    public static TextView barcodeValue;
    public static TextView imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scanResult = findViewById(R.id.scan_result);
        scanButton = findViewById(R.id.scan_button);
        productImage = findViewById(R.id.image);
        barcodeValue = findViewById(R.id.barcodeValue);
        imageId = findViewById(R.id.imageId);

        // button click to start scan & network request
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanResult.setText(null);
                productImage.setImageBitmap(null);
                barcodeValue.setText(null);
                imageId.setText(null);
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });


    }
}
