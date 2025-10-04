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

public class Movie1Activity extends AppCompatActivity {

    private Button btnBuyTicket, btnNextMovie, btnComingSoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);

        Intent intent = getIntent();
        String FirstName = intent.getStringExtra("firstname");
        String LastName = intent.getStringExtra("lastname");
        String Email = intent.getStringExtra("email");
        String Mobile = intent.getStringExtra("mobile");
        String Password = intent.getStringExtra("password");

        btnBuyTicket = findViewById(R.id.btn_buy_ticket);
        btnNextMovie = findViewById(R.id.btn_next_movie);
        btnComingSoon = findViewById(R.id.btn_coming_soon);

        btnNextMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie1Activity.this, Movie2Activity.class);

                intent.putExtra("firstname", FirstName);
                intent.putExtra("lastname", LastName);
                intent.putExtra("email", Email);
                intent.putExtra("mobile", Mobile);
                intent.putExtra("password", Password);

                startActivity(intent);
            }
        });

        btnBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie1Activity.this, DateTimeActivity.class);

                intent.putExtra("firstname", FirstName);
                intent.putExtra("lastname", LastName);
                intent.putExtra("email", Email);
                intent.putExtra("mobile", Mobile);
                intent.putExtra("password", Password);

                startActivity(intent);
            }
        });

        btnComingSoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie1Activity.this, ComingSoonActivity.class);

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