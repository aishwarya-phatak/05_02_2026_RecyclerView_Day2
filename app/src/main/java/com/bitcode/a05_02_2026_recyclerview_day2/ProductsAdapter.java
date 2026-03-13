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

public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ImageView imageView1;
    TextView txtViewProductName, txtViewProductPrice, userTextView;
    ArrayList<Product> productArrayList;
    ArrayList<User> userArrayList;

    final int PRODUCT_VIEW_HOLDER = 1, USER_VIEW_HOLDER = 2;

    public ProductsAdapter(ArrayList<Product> products, ArrayList<User> users) {
        this.productArrayList = products;
        this.userArrayList = users;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
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
                    Intent i = new Intent(itemView.getContext(), ProductDetailsActivity.class);
//                    i.putExtra("pr_id",eachProduct.getProductId());
//                    i.putExtra("pr_name",eachProduct.getProductName());
//                    i.putExtra("pr_price",eachProduct.getProductPrice());
                    i.putExtra("product", eachProduct);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTextView = itemView.findViewById(R.id.userTextView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == PRODUCT_VIEW_HOLDER) {
            View productView = layoutInflater.inflate(R.layout.product_view, null);

            imageView1 = productView.findViewById(R.id.imgView1);
            txtViewProductName = productView.findViewById(R.id.txtViewProductName);
            txtViewProductPrice = productView.findViewById(R.id.txtViewProductPrice);

//        txtViewProductName.setOnClickListener(new TxtViewProductNameClickListener());

            return new ProductViewHolder(productView);
        } else {
            View userView = layoutInflater.inflate(R.layout.user_view, null);
            userTextView = userView.findViewById(R.id.userTextView);
            return new UserViewHolder(userView);
        }
    }

    public class TxtViewProductNameClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), ProductDetailsActivity.class);
            i.putExtra("product_name", "Product test");
            i.putExtra("product_price", 1999);
            view.getContext().startActivity(i);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int holderType = holder.getItemViewType();
        switch (holderType) {
            case PRODUCT_VIEW_HOLDER :
                Product product = productArrayList.get(position / 2);
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
            case USER_VIEW_HOLDER :
                User user = userArrayList.get((position - 1) / 2);
                userTextView = holder.itemView.findViewById(R.id.userTextView);
                userTextView.setText(user.getUsername());
        }

        //way 2 - by if
//        if (holder.getItemViewType() == PRODUCT_VIEW_HOLDER) {
//            Product product = productArrayList.get(position / 2);
//
//            imageView1 = holder.itemView.findViewById(R.id.imgView1);
//            txtViewProductName = holder.itemView.findViewById(R.id.txtViewProductName);
//            txtViewProductPrice = holder.itemView.findViewById(R.id.txtViewProductPrice);
//
//            imageView1.setImageResource(R.drawable.ic_launcher_background);
//            txtViewProductName.setText(product.getProductName());
//            txtViewProductPrice.setText(product.getProductPrice() + "");
//
//            //attaching listener to view
////            holder.itemView.setOnClickListener(
////                    new View.OnClickListener() {
////                        @Override
////                        public void onClick(View view) {
////                            Intent intent1 = new Intent(view.getContext(),ProductDetailsActivity.class);
////                            intent1.putExtra("p_name",productArrayList.get(position).getProductName());
////                            intent1.putExtra("p_price",productArrayList.get(position).getProductPrice());
////                            view.getContext().startActivity(intent1);
////                        }
////                    }
////            );
//
////            txtViewProductName.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    Intent intent1 = new Intent(view.getContext(),ProductDetailsActivity.class);
////                    intent1.putExtra("p_name",productArrayList.get(position).getProductName());
////                    intent1.putExtra("p_price",productArrayList.get(position).getProductPrice());
////                    view.getContext().startActivity(intent1);
////                }
////            });
//        }
//
//        if (holder.getItemViewType() == USER_VIEW_HOLDER) {
//            User user = userArrayList.get((position - 1) / 2);
//            userTextView = holder.itemView.findViewById(R.id.userTextView);
//            userTextView.setText(user.getUsername());
//        }
    }

    @Override
    public int getItemCount() {
        return productArrayList.size() + userArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return PRODUCT_VIEW_HOLDER;
        } else {
            return USER_VIEW_HOLDER;
        }
    }
}
