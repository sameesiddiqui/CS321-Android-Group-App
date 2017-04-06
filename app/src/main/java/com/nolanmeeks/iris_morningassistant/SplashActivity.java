package com.nolanmeeks.iris_morningassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
}
