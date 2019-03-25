package com.example.colliensepodder.laundry.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.colliensepodder.laundry.Activity.database.Database;
import com.example.colliensepodder.laundry.R;
import com.example.colliensepodder.laundry.models.Client;
import com.example.colliensepodder.laundry.models.Owner;

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

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPhoneNumber.getText().toString().isEmpty()) {
                    editTextPhoneNumber.setError("invalid");
                    return;
                }
                if (editTextPassword.getText().toString().isEmpty()) {
                    editTextPassword.setError("Invalid");
                    return;
                }
                if (editTextPassword.length() < 8) {
                    editTextPassword.setError("Password length minimum 8 character");
                    return;
                }

                Owner owner = new Owner();
                owner.setPhoneNumber(editTextPhoneNumber.getText().toString());
                owner.setPassword(editTextPassword.getText().toString());
                Database database = new Database();
                database.ownerSignIn(OwnerLogin.this, owner, new Database.OwnerSignin() {
                    @Override
                    public void issignin(Boolean IsSignIn) {
                        if (IsSignIn == true) {
                            Toast.makeText(getApplicationContext(), "Login succesfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(OwnerLogin.this, LaundryShopList.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        textView_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OwnerLogin.this, OwnerSignUp.class);
                startActivity(i);
            }
        });
    }
}
