package com.example.colliensepodder.laundry.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.colliensepodder.laundry.R;

/**
 * Created by colliensepodder on 3/17/2019.
 */
public class OwnerLogin extends AppCompatActivity {

    public ImageView imgview_ic_owner_login;
    public EditText editText_firstname;
    public EditText editText_lastname;
    public EditText editTextPhoneNumber;
    public EditText editTextPassword;
    public Button button_signin;
    public TextView textView_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        imgview_ic_owner_login = findViewById(R.id.imgview_ic_owner_login);
        editText_firstname = findViewById(R.id.editText_firstname);
        editText_lastname = findViewById(R.id.editText_lastname);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        button_signin = findViewById(R.id.button_signin);
        textView_signup = findViewById(R.id.textView_signup);

        textView_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OwnerLogin.this, OwnerSignUp.class);
                startActivity(i);
            }
        });
    }
}
