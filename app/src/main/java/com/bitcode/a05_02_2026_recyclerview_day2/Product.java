package com.bitcode.a05_02_2026_recyclerview_day2;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private int productPrice;

    public Product(){
        this.productId = 18;
        this.productName = "Iron";
        this.productPrice = 700;
    }

    public Product(int pId, String pName, int pPrice){
        this.productId = pId;
        this.productName = pName;
        this.productPrice = pPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return "product id : " + productId + "  product name : " + productName;
    }
}
