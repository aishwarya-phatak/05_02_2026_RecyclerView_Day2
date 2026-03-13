package com.bitcode.a05_02_2026_recyclerview_day2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewForProducts;
    ProductsAdapter productsAdapter;
    ArrayList<Product> productArrayList;
    ArrayList<User> userArrayList;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initArrayList();
        initViews();
    }

    public void initViews(){
        recyclerViewForProducts = findViewById(R.id.recyclerViewForProducts);
        productsAdapter = new ProductsAdapter(productArrayList,userArrayList);
        recyclerViewForProducts.setAdapter(productsAdapter);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewForProducts.setLayoutManager(linearLayoutManager);
    }

    public void initArrayList(){
        productArrayList = new ArrayList<Product>();
        for(int i = 0;i<10;i++) {
            productArrayList.add(new Product(i + 3423,
                    "Product " + i,
                    i * 2313 + 500));
        }

        userArrayList = new ArrayList<User>();
        for(int i = 0;i<10;i++){
            userArrayList.add(new User(i + 105, "User " + i));
        }
    }
}