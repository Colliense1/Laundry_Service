package com.example.colliensepodder.laundry.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.colliensepodder.laundry.R;

/**
 * Created by colliensepodder on 3/18/2019.
 */

public class LaundryListAdapter extends RecyclerView.Adapter<LaundryListAdapter.ViewHolder> {


    //LayoutInflater layoutInflater;
    private String[] data;

    public LaundryListAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_list_recycler_layout, parent, false);
        //View view = layoutInflater.inflate(R.layout.shop_list_recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
