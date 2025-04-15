package com.training.Demoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.Demoapp.databasehelper.Databasehelper;

public class MyprofileActivity extends AppCompatActivity {
    Databasehelper dbHelper;
    TextView tv_profile_title, tv_name, tv_course, tv_email, tv_phone;
    Button btn_edit_profile;
    String studentId = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_myprofile);
        dbHelper = new Databasehelper(this);
        tv_profile_title = findViewById(R.id.tv_profile_title);
        tv_name = findViewById(R.id.tv_name);
        tv_course = findViewById(R.id.tv_course);
        tv_email = findViewById(R.id.tv_email);
        tv_phone = findViewById(R.id.tv_phone);

        btn_edit_profile=findViewById(R.id.btn_edit_profile);

        btn_edit_profile.setOnClickListener(v -> {
            startActivity(new Intent(MyprofileActivity.this, Profileview.class));
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferencesProfileActivity = getSharedPreferences("userData",MODE_PRIVATE);
        String savedName =  sharedPreferencesProfileActivity.getString("name", "");
        String savedCourse =  sharedPreferencesProfileActivity.getString("course", "");
        String savedEmail =  sharedPreferencesProfileActivity.getString("email", "");
        String savedPhone =  sharedPreferencesProfileActivity.getString("phone", "");

        tv_name.setText("Name : "+savedName);
        tv_course.setText("Course : "+savedCourse);
        tv_email.setText("Email : "+savedEmail);
        tv_phone.setText("Phone : "+savedPhone);

        BackDashboardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyprofileActivity.this, DashboardActivity.class));
            }
        });

        BackMyprofileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyprofileActivity.this, Profileview.class));
            }
        });
    }
}