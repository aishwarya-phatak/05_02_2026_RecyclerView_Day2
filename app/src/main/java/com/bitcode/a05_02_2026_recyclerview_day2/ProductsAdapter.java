package com.bitcode.a05_02_2026_recyclerview_day2;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    ImageView imageView1;
    TextView txtViewProductName, txtViewProductPrice;
    ArrayList<Product> productArrayList;

    public ProductsAdapter(ArrayList<Product> products){
        this.productArrayList = products;
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder{
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imgView1);
            txtViewProductName = itemView.findViewById(R.id.txtViewProductName);
            txtViewProductPrice = itemView.findViewById(R.id.txtViewProductPrice);

            //way 3 - attaching listener in constructor / implementing serializable in Product class
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product eachProduct = productArrayList.get(getBindingAdapterPosition());
                    Intent i = new Intent(itemView.getContext(),ProductDetailsActivity.class);
//                    i.putExtra("pr_id",eachProduct.getProductId());
//                    i.putExtra("pr_name",eachProduct.getProductName());
//                    i.putExtra("pr_price",eachProduct.getProductPrice());
                    i.putExtra("product",eachProduct);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view,null);

        imageView1 = productView.findViewById(R.id.imgView1);
        txtViewProductName = productView.findViewById(R.id.txtViewProductName);
        txtViewProductPrice = productView.findViewById(R.id.txtViewProductPrice);

//        txtViewProductName.setOnClickListener(new TxtViewProductNameClickListener());

        return new ProductViewHolder(productView);
    }

    public class TxtViewProductNameClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), ProductDetailsActivity.class);
            i.putExtra("product_name","Product test");
            i.putExtra("product_price",1999);
            view.getContext().startActivity(i);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            Product product = productArrayList.get(position);

            imageView1 = holder.itemView.findViewById(R.id.imgView1);
            txtViewProductName = holder.itemView.findViewById(R.id.txtViewProductName);
            txtViewProductPrice = holder.itemView.findViewById(R.id.txtViewProductPrice);

            imageView1.setImageResource(R.drawable.ic_launcher_background);
            txtViewProductName.setText(product.getProductName());
            txtViewProductPrice.setText(product.getProductPrice() + "");

            //attaching listener to view
//            holder.itemView.setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent1 = new Intent(view.getContext(),ProductDetailsActivity.class);
//                            intent1.putExtra("p_name",productArrayList.get(position).getProductName());
//                            intent1.putExtra("p_price",productArrayList.get(position).getProductPrice());
//                            view.getContext().startActivity(intent1);
//                        }
//                    }
//            );

//            txtViewProductName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent1 = new Intent(view.getContext(),ProductDetailsActivity.class);
//                    intent1.putExtra("p_name",productArrayList.get(position).getProductName());
//                    intent1.putExtra("p_price",productArrayList.get(position).getProductPrice());
//                    view.getContext().startActivity(intent1);
//                }
//            });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
