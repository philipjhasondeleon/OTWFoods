package com.example.otwfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.otwfoods.Administrator.Activities.SignInActivityAppAdmin;
import com.example.otwfoods.Client.Activities.SignInActivity;
import com.example.otwfoods.RestaurantUser.RestaurantSigninActivity;
import com.example.otwfoods.Rider.SignInAsRiderActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton clientUser, riderUser, administratorUser, restaurantUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientUser = findViewById(R.id.btn_Client_SignIn);
        clientUser.setOnClickListener(this);

        restaurantUser = findViewById(R.id.btn_Restaurant_SignIn);
        restaurantUser.setOnClickListener(this);

        riderUser = findViewById(R.id.btn_Rider_SignIn);
        riderUser.setOnClickListener(this);

        administratorUser = findViewById(R.id.btn_Administrator_SignIn);
        administratorUser.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == clientUser) {
            Intent clientUser = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(clientUser);
        } else if (view == restaurantUser) {
            Intent restaurantUser = new Intent(MainActivity.this, RestaurantSigninActivity.class);
            startActivity(restaurantUser);
        } else if (view == riderUser) {
            Intent riderUser = new Intent(MainActivity.this, SignInAsRiderActivity.class);
            startActivity(riderUser);
        } else if (view == administratorUser) {
            Intent administratorUser = new Intent(MainActivity.this, SignInActivityAppAdmin.class);
            startActivity(administratorUser);
        }
    }
}