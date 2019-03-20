package com.example.colliensepodder.laundry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.colliensepodder.laundry.Activity.OwnerLogin;
import com.example.colliensepodder.laundry.Activity.UserLogin;

/**
 * Created by colliensepodder on 3/17/2019.
 */
public class FirstActivity extends AppCompatActivity {

    public Button btnuser;
    public Button btnowner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnuser = findViewById(R.id.btnuser);
        btnowner = findViewById(R.id.btnowner);

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstActivity.this, UserLogin.class);
                startActivity(i);

            }
        });
        btnowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstActivity.this, OwnerLogin.class);
                startActivity(i);

            }
        });
    }

}
