package com.training.Demoapp;

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

public class MainActivity extends AppCompatActivity {

    EditText edt_email,edt_password;
    Button btn_login;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_email=findViewById(R.id.edt_email);
        edt_password=findViewById(R.id.edt_password);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        SharedPreferences sharedPreferences = getSharedPreferences("user prefs",MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name","");
        String savedEmail = sharedPreferences.getString("email","");
        String savedPassword = sharedPreferences.getString("password","");


        btn_login.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             String email = edt_email.getText().toString();
                                             String password = edt_password.getText().toString();
                                             if (email.equals(savedEmail) && password.equals(savedPassword)) {
                                                 Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                                 startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                                             } else {
                                                 Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                                             }
                                         }
                                         });
                                         btn_register.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 startActivity(new Intent(MainActivity.this, RegistrationActivity.class));

                                             }
                                         });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }
    );
    }
}