package com.example.colliensepodder.laundry.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.colliensepodder.laundry.R;

/**
 * Created by colliensepodder on 4/4/2019.
 */

public class OwnerAdding extends AppCompatActivity {

    public EditText editText_yourshopname;
    public EditText editTextPhoneNumber;
    public EditText editTextEmail;
    public EditText editTextAddress;
    public EditText editText_shirtCost;
    public EditText editText_pantCost;
    public EditText editText_blanketCost;
    public EditText editText_curtainsCost;
    public Button button_add;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_adding);

        editText_yourshopname = findViewById(R.id.editText_yourshopname);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAddress = findViewById(R.id.editTextAddress);
        editText_shirtCost = findViewById(R.id.editText_shirtCost);
        editText_pantCost = findViewById(R.id.editText_pantCost);
        editText_blanketCost = findViewById(R.id.editText_blanketCost);
        editText_curtainsCost = findViewById(R.id.editText_curtainsCost);
        button_add = findViewById(R.id.button_add);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText_yourshopname.getText().toString().isEmpty()) {
                    editText_yourshopname.setError("Enter shop name");
                    return;
                }
                if (editTextPhoneNumber.getText().toString().isEmpty()) {
                    editTextPhoneNumber.setError("Enter phone number");
                    return;
                }
                if (editTextPhoneNumber.getText().toString().length() != 11) {
                    editTextPhoneNumber.setError("The Number is not Valid");
                    return;
                }
                if (!editTextPhoneNumber.getText().toString().substring(0, 2).equals("01")) {
                    editTextPhoneNumber.setError("The Number is not Valid");
                    return;
                }
                if (editTextEmail.getText().toString().contains("@gmail.com") || editTextEmail.getText().toString().contains("@diu.edu.bd")
                        || editTextEmail.getText().toString().contains("@yahoo.com")) {

                } else {
                    editTextEmail.setError("Invalid email");
                }
                if (editTextAddress.getText().toString().isEmpty()) {
                    editTextAddress.setError("Enter address");
                    return;
                }
                if (editText_shirtCost.getText().toString().isEmpty()) {
                    editText_shirtCost.setError("Enter shirt cost");
                    return;
                }
                if (editText_pantCost.getText().toString().isEmpty()) {
                    editText_pantCost.setError("Enter pant cost");
                    return;
                }
                if (editText_blanketCost.getText().toString().isEmpty()) {
                    editText_blanketCost.setError("Enter blanket cost");
                    return;
                }
                if (editText_curtainsCost.getText().toString().isEmpty()) {
                    editText_curtainsCost.setError("Enter curtains cost");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
            }
        });

    }
}
