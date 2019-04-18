package com.example.colliensepodder.laundry.Activity.database;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.colliensepodder.laundry.Activity.UserSignUp;
import com.example.colliensepodder.laundry.models.Client;
import com.example.colliensepodder.laundry.models.Owner;
import com.example.colliensepodder.laundry.models.Shop;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Database {
    DatabaseReference myDatabaseRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference clientRef = myDatabaseRef.child("client");
    DatabaseReference ownerRef = myDatabaseRef.child("owner");
    DatabaseReference shopAddRef = myDatabaseRef.child("shop");

    public interface ClientSignup {
        public void issignup(Boolean IsSignUp);
    }

    public interface ClientSignin {
        public void issignin(Boolean IsSignIn);
    }

    public interface OwnerSignup {
        public void issignup(Boolean IsSignUp);
    }

    public interface OwnerSignin {
        public void issignin(Boolean IsSignIn);
    }

    public interface OwnerShopAdd {
        public void isShopAdd(Boolean IsSignIn);
    }

    public interface AllShop {
        public void getAllShop(ArrayList<Shop> shops);
    }


    public void clientSignUp(Context context, final Client client, final ClientSignup clientSignup) {
        clientRef.push().setValue(client).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                clientSignup.issignup(true);

            }
        });

    }

    public void shopAdd(Context context, final Shop shop, final OwnerShopAdd ownerShopAdd) {
        shopAddRef.push().setValue(shop).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                ownerShopAdd.isShopAdd(true);

            }

        });

    }


    public void clientSignIn(Context context, final Client client, final ClientSignin clientSignin) {

        clientRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean flag = false;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Client dbClient = dsp.getValue(Client.class);
                    if (dbClient.getPhoneNumber().toString().equals(client.getPhoneNumber()) && dbClient.getPassword().toString().equals(client.getPassword())) {
                        flag = true;
                        // break;
                    }
                }
                clientSignin.issignin(flag);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getAllShop(Context context, final AllShop allShop) {

        shopAddRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean flag = false;
                ArrayList<Shop> shops = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    //  Shop dbClient = dsp.getValue(Shop.class);
                    shops.add(dsp.getValue(Shop.class));


                    /*if (dbClient.getPhoneNumber().toString().equals(client.getPhoneNumber()) && dbClient.getPassword().toString().equals(client.getPassword())) {
                        flag = true;
                        // break;
                    }*/
                }
                allShop.getAllShop(shops);
                //clientSignin.issignin(flag);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    //Owner Signup Signin
    public void ownerSignUp(Context context, final Owner owner, final OwnerSignup ownerSignup) {
        ownerRef.push().setValue(owner).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                ownerSignup.issignup(true);

            }
        });

    }

    public void ownerSignIn(Context context, final Owner owner, final OwnerSignin ownerSignin) {

        ownerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean flag = false;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Owner dbOwner = dsp.getValue(Owner.class);
                    if (dbOwner.getPhoneNumber().toString().equals(owner.getPhoneNumber()) && dbOwner.getPassword().toString().equals(owner.getPassword())) {
                        flag = true;
                        // break;
                    }
                }
                ownerSignin.issignin(flag);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
