package com.bitcode.a05_02_2026_recyclerview_day2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView txtProductName, txtProductPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_activity);
        txtProductName = findViewById(R.id.txtViewProductDetailsName);
        txtProductPrice = findViewById(R.id.txtViewProductDetailsPrice);
        extractDataAndBind();
    }

    public void extractDataAndBind() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        //attaching listeners from onCreateViewHolder
//        String pName = bundle.getString("product_name");
//        int prPrice = bundle.getInt("product_price");


        //attachment of listeners from onBindViewHolder
        String prName = bundle.getString("p_name");
        int prPrice = bundle.getInt("p_price");

        txtProductName.setText(prName);
        txtProductPrice.setText(prPrice + " ");
    }
}
