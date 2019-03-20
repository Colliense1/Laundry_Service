package com.example.colliensepodder.laundry.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.colliensepodder.laundry.R;

/**
 * Created by colliensepodder on 3/17/2019.
 */
public class OwnerSignUp extends AppCompatActivity {

    public ImageView imgview_ic_owner_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_up);

        imgview_ic_owner_signup = findViewById(R.id.imgview_ic_owner_signup);
    }
}
