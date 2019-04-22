package com.example.colliensepodder.laundry.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.colliensepodder.laundry.Activity.OwnerAdding;
import com.example.colliensepodder.laundry.Activity.ShowOwnerAddData;
import com.example.colliensepodder.laundry.Activity.database.Database;
import com.example.colliensepodder.laundry.R;
import com.example.colliensepodder.laundry.models.Shop;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colliensepodder on 3/18/2019.
 */

public class MyShopDetailsAdopter extends RecyclerView.Adapter<MyShopDetailsAdopter.ViewHolder> {


    private ArrayList<Shop> shops;
    DatabaseReference databaseReference;
    Context mcontext;

    public MyShopDetailsAdopter(ArrayList<Shop> data) {
        this.shops = data;

        databaseReference = FirebaseDatabase.getInstance().getReference().child("shop");
        databaseReference.addChildEventListener(new GetKey());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_details, parent, false);
        return new ViewHolder(view);
    }

    List<String> keylist = new ArrayList<>();
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.shopNameTV.setText(shops.get(position).getShopName().toString());
        holder.shopAddressTV.setText(shops.get(position).getAddress().toString());
        holder.textView_phoneNumber.setText(shops.get(position).getPhoneNumber().toString());
        holder.textView_shirtCost.setText(shops.get(position).getShirtCost().toString());
        holder.textView_pantCost.setText(shops.get(position).getPantCost().toString());
        holder.textView_blanketCost.setText(shops.get(position).getBlanketCost().toString());
        holder.textView_curtainsCost.setText(shops.get(position).getCurtainCost().toString());

        holder.textView_editShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        holder.textView_deleteShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(view.getContext())
                        .setMessage("Do you really want to delete?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                databaseReference.child(keylist.get(position)).removeValue();
                                ShowOwnerAddData.getData();

                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopNameTV;
        TextView shopAddressTV;
        TextView textView_phoneNumber;
        TextView textView_shirtCost;
        TextView textView_pantCost;
        TextView textView_blanketCost;
        TextView textView_curtainsCost;
        TextView textView_editShop;
        TextView textView_deleteShop;


        public ViewHolder(View itemView) {
            super(itemView);
            shopNameTV = itemView.findViewById(R.id.ShopNameTV);
            shopAddressTV = itemView.findViewById(R.id.ShopAddressTV);
            textView_phoneNumber = itemView.findViewById(R.id.textView_phoneNumber);
            textView_shirtCost = itemView.findViewById(R.id.textView_shirtCost);
            textView_pantCost = itemView.findViewById(R.id.textView_pantCost);
            textView_blanketCost = itemView.findViewById(R.id.textView_blanketCost);
            textView_curtainsCost = itemView.findViewById(R.id.textView_curtainsCost);
            textView_editShop = itemView.findViewById(R.id.textView_editShop);
            textView_deleteShop = itemView.findViewById(R.id.textView_deleteShop);

        }
    }
    public class GetKey implements ChildEventListener {

        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            String key = dataSnapshot.getKey();
            keylist.add(key);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }
}
