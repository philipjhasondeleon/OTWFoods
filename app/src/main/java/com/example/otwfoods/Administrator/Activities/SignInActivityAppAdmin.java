package com.example.otwfoods.Administrator.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.otwfoods.Administrator.ConstantAdmin;
import com.example.otwfoods.Administrator.Model.UserAdministrator;
import com.example.otwfoods.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivityAppAdmin extends AppCompatActivity {

    TextInputEditText edtPhone, edtPassword;
    MaterialButton btnSignInAppAdmin;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_app_admin);

        edtPhone = findViewById(R.id.tiet_administrator_user_phone);
        edtPassword = findViewById(R.id.tiet_administrator_user_password);

        db = FirebaseDatabase.getInstance();
        users = db.getReference("Administrator");

        btnSignInAppAdmin = findViewById(R.id.btn_administrator_user_Sign_in);
        btnSignInAppAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSignInAppAdministrator(edtPhone.getText().toString(),edtPassword.getText().toString());
            }
        });
    }

    private void btnSignInAppAdministrator(String phone, String password){

        final ProgressDialog mDialog = new ProgressDialog(SignInActivityAppAdmin.this);
        mDialog.setMessage("Please wait..");
        mDialog.show();

        final String localPhone = phone;
        final String localPassword = password;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(localPhone).exists()) {

                    mDialog.dismiss();
                    UserAdministrator user = snapshot.child(localPhone).getValue(UserAdministrator.class);
                    user.setPhone(localPhone);
                    if(user.getPassword().equals(localPassword)){
                        Intent login = new Intent(SignInActivityAppAdmin.this, AddRestaurantActivity.class);
                        ConstantAdmin.currentUser = user;
                        startActivity(login);
                        finish();

                    }else {
                        Toast.makeText(SignInActivityAppAdmin.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(SignInActivityAppAdmin.this, "User not Exist in Database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}