package com.training.Demoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    TextView dashboardtitle;
    Button dashboard_subject;
    Button linear_profile;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        dashboardtitle = findViewById(R.id.dashboardtitle);
        dashboard_subject = findViewById(R.id.dashboard_subject);
        linear_profile = findViewById(R.id.linear_profile);

        linear_profile.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, MyprofileActivity.class));
    });

        SharedPreferences sharedPreferences = getSharedPreferences("user prefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","Users");


        dashboardtitle.setText("Welcome, " + name + "!" + "How are you today?");
        dashboard_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, subjectlist.class));
            }
        });
        linear_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, MyprofileActivity.class));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}