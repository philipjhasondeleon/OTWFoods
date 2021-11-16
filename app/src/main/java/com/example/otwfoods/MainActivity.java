package com.example.otwfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
            Toast.makeText(this, "clicked Client", Toast.LENGTH_SHORT).show();
        } else if (view == restaurantUser) {
            Toast.makeText(this, "clicked Restaurant", Toast.LENGTH_SHORT).show();
        } else if (view == riderUser) {
            Toast.makeText(this, "clicked Rider", Toast.LENGTH_SHORT).show();
        } else if (view == administratorUser) {
            Toast.makeText(this, "clicked Administrator", Toast.LENGTH_SHORT).show();
        }
    }
}