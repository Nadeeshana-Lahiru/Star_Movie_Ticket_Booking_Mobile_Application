package com.example.starmovieticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DateTimeActivity extends AppCompatActivity {

    private RadioGroup rgDates, rgTimes;
    private Button btnProceed;
    private String selectedDate = "";
    private String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        rgDates = findViewById(R.id.rg_dates);
        rgTimes = findViewById(R.id.rg_times);
        btnProceed = findViewById(R.id.btn_proceed);

        Intent intent = getIntent();
        String FirstName = intent.getStringExtra("firstname");
        String LastName = intent.getStringExtra("lastname");
        String Email = intent.getStringExtra("email");
        String Mobile = intent.getStringExtra("mobile");
        String Password = intent.getStringExtra("password");

        rgDates.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_date1) {
                    selectedDate = "OCT 01 WED";
                } else if (checkedId == R.id.rb_date2) {
                    selectedDate = "OCT 02 THU";
                } else if (checkedId == R.id.rb_date3) {
                    selectedDate = "OCT 03 FRI";
                } else if (checkedId == R.id.rb_date4) {
                    selectedDate = "OCT 04 SAT";
                }
            }
        });

        rgTimes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_time1) {
                    selectedTime = "10:30 AM";
                } else if (checkedId == R.id.rb_time2) {
                    selectedTime = "02:00 PM";
                } else if (checkedId == R.id.rb_time3) {
                    selectedTime = "07:30 PM";
                }
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rgDates.getCheckedRadioButtonId() == -1){
                    Toast.makeText(DateTimeActivity.this, "Please select a date.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rgTimes.getCheckedRadioButtonId() == -1){
                    Toast.makeText(DateTimeActivity.this, "Please select a time.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent selectSeatIntent = new Intent(DateTimeActivity.this, SelectSeatActivity.class);

                selectSeatIntent.putExtra("firstname", FirstName);
                selectSeatIntent.putExtra("lastname", LastName);
                selectSeatIntent.putExtra("email", Email);
                selectSeatIntent.putExtra("mobile", Mobile);
                selectSeatIntent.putExtra("password", Password);
                selectSeatIntent.putExtra("select_date", selectedDate);
                selectSeatIntent.putExtra("select_time", selectedTime);

                startActivity(selectSeatIntent);
            }
        });
    }
}