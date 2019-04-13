package com.example.colliensepodder.laundry.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.colliensepodder.laundry.R;
import com.example.colliensepodder.laundry.models.Shop;

import java.util.ArrayList;

/**
 * Created by colliensepodder on 3/18/2019.
 */

public class MyShopDetailsAdopter extends RecyclerView.Adapter<MyShopDetailsAdopter.ViewHolder> {


    //LayoutInflater layoutInflater;
    private ArrayList<Shop> shops;

    public MyShopDetailsAdopter(ArrayList<Shop> data) {
        this.shops = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_details, parent, false);
        //View view = layoutInflater.inflate(R.layout.shop_list_recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.shopNameTV.setText(shops.get(position).getShopName().toString());
        holder.shopAddressTV.setText(shops.get(position).getAddress().toString());


    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopNameTV;
        TextView shopAddressTV;

        public ViewHolder(View itemView) {
            super(itemView);
            shopNameTV = itemView.findViewById(R.id.ShopNameTV);
            shopAddressTV = itemView.findViewById(R.id.ShopAddressTV);
        }
    }
}
