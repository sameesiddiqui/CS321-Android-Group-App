package com.nolanmeeks.iris_morningassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_weather.xml
        setContentView(R.layout.activity_weather);
    }
}