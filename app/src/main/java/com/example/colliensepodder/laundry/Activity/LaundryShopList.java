package com.example.colliensepodder.laundry.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.colliensepodder.laundry.Adapter.LaundryListAdapter;
import com.example.colliensepodder.laundry.R;

/**
 * Created by colliensepodder on 3/18/2019.
 */
public class LaundryShopList extends AppCompatActivity {

    public RecyclerView recyclerview_shoplist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_shop_list);

        recyclerview_shoplist = findViewById(R.id.recyclerview_shoplist);
        recyclerview_shoplist.setLayoutManager(new LinearLayoutManager(this));
        String[] shopname = {"Calcutta dry cleaners", "Bappi Automatic Dry Cleaners", "Bandbox", "National Laundry Service",
                "Anando Dry Cleaners", "Mohima Dry Cleaners", "Minhaj Laundry Service", "Modhubazar DryCleaners",
                "Park View Automatic Dry Cleaners"};

        recyclerview_shoplist.setAdapter(new LaundryListAdapter(shopname));
    }
}
