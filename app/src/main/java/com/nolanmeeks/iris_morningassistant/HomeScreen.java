package com.nolanmeeks.iris_morningassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;


public class HomeScreen extends AppCompatActivity implements View.OnClickListener{

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_home_screen);

        // Locate the button in activity_main.xml
        Button weatherButton = (Button) findViewById(R.id.WeatherButton);
        weatherButton.setOnClickListener(this);
        Button calendarButton = (Button) findViewById(R.id.CalendarButton);
        calendarButton.setOnClickListener(this);
        Button alarmButton = (Button) findViewById(R.id.AlarmButton);
        alarmButton.setOnClickListener(this);
    }
    // Capture button clicks
    public void onClick(View clicked) {
        switch(clicked.getId()){

            // Start Weather Activity
            case R.id.WeatherButton:
                Intent weatherIntent = new Intent(HomeScreen.this, WeatherActivity.class);
                startActivity(weatherIntent);
                break;

            // Start Calendar Activity
            case R.id.CalendarButton:
                Intent calendarIntent = new Intent(HomeScreen.this, CalendarActivity.class);
                startActivity(calendarIntent);
                break;

            // Start Alarm Activity
            case R.id.AlarmButton:
                // Start Alarm
                Intent alarmIntent = new Intent(HomeScreen.this, AlarmActivity.class);
                startActivity(alarmIntent);
                break;

            default:
                break;
        }

    }
}