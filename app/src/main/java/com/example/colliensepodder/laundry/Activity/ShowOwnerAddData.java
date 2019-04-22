package com.example.colliensepodder.laundry.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.colliensepodder.laundry.Activity.database.Database;
import com.example.colliensepodder.laundry.Adapter.MyShopDetailsAdopter;
import com.example.colliensepodder.laundry.R;
import com.example.colliensepodder.laundry.models.Shop;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.colliensepodder.laundry.Activity.OwnerLogin.LOGGEDIN_OWNER_PHONE;

public class ShowOwnerAddData extends AppCompatActivity {
    RecyclerView myShopRV;
    ImageView imageView_back;

    public static ArrayList<Shop> shops;
    public  static MyShopDetailsAdopter myShopDetailsAdopter;
    public static DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_owner_add_data);

        myShopRV = findViewById(R.id.MyShopRV);
        myShopRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("shop");
        getData();

        imageView_back = findViewById(R.id.imageView_back);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setMyShop();

    }

    private void setMyShop() {
        final ArrayList<Shop> myShops = new ArrayList<>();
        Database db = new Database();
        db.getAllShop(this, new Database.AllShop() {
            @Override
            public void getAllShop(ArrayList<Shop> shops) {
                for (int i = 0; i < shops.size(); i++) {
                    if (shops.get(i).getPhoneNumber().equals(LOGGEDIN_OWNER_PHONE)) {
                        myShops.add(shops.get(i));
                    }

                }

                myShopRV.setAdapter(new MyShopDetailsAdopter(shops));

            }
        });
    }

    public void addNewShop(View view) {
        startActivity(new Intent(this,OwnerAdding.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void clickBack(View view) {
        this.finish();
    }

    public static  void  getData(){

        databaseReference.child("shop").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Shop shop1 = dataSnapshot.getValue(Shop.class);
                shops.add(shop1);
                myShopDetailsAdopter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                myShopDetailsAdopter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
