package com.example.starmovieticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ComingSoonActivity extends AppCompatActivity {

    private Button btnNowShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coming_soon);

        btnNowShowing = findViewById(R.id.btn_coming_soon_now_showing);

        Intent intent = getIntent();
        String FirstName = intent.getStringExtra("firstname");
        String LastName = intent.getStringExtra("lastname");
        String Email = intent.getStringExtra("email");
        String Mobile = intent.getStringExtra("mobile");
        String Password = intent.getStringExtra("password");

        btnNowShowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComingSoonActivity.this, Movie1Activity.class);

                intent.putExtra("firstname", FirstName);
                intent.putExtra("lastname", LastName);
                intent.putExtra("email", Email);
                intent.putExtra("mobile", Mobile);
                intent.putExtra("password", Password);

                startActivity(intent);
            }
        });
    }
}