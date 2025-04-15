package com.training.Demoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
    Button linear_lay_alreadyhaveaccount;
    EditText linear_lay_fullname,linear_lay_email,linear_lay_password;
    Button linear_lay_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);


        linear_lay_alreadyhaveaccount=findViewById(R.id.linear_lay_alreadyhaveaccount);
        linear_lay_fullname=findViewById(R.id.linear_lay_fullname);
        linear_lay_email=findViewById(R.id.linear_lay_email);
        linear_lay_password=findViewById(R.id.linear_lay_password);
        linear_lay_button=findViewById(R.id.linear_lay_button);


        linear_lay_alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

        linear_lay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = linear_lay_fullname.getText().toString();
                String email = linear_lay_email.getText().toString();
                String password = linear_lay_password.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }else{

                    SharedPreferences sharedPreferences = getSharedPreferences("user prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",name);
                    editor.putString("email",email);
                    editor.putString("password",password);
                    editor.apply();

                    Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}