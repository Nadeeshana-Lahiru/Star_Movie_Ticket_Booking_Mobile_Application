package com.example.starmovieticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private String registeredFirstName, registeredLastName, registeredEmail, registeredMobile, registeredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_login_register);

        Intent intent = getIntent();
        registeredFirstName = intent.getStringExtra("firstname");
        registeredLastName = intent.getStringExtra("lastname");
        registeredEmail = intent.getStringExtra("email");
        registeredMobile = intent.getStringExtra("mobile");
        registeredPassword = intent.getStringExtra("password");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                    Intent homeIntent = new Intent(LoginActivity.this, Movie1Activity.class);

                    homeIntent.putExtra("firstname", registeredFirstName);
                    homeIntent.putExtra("lastname", registeredLastName);
                    homeIntent.putExtra("email", registeredEmail);
                    homeIntent.putExtra("mobile", registeredMobile);
                    homeIntent.putExtra("password", registeredPassword);

                    startActivity(homeIntent);

                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}