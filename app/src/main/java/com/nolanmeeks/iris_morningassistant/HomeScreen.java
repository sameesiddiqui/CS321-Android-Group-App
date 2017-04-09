package com.nolanmeeks.iris_morningassistant;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;


public class HomeScreen extends AppCompatActivity implements View.OnClickListener{
    FloatingActionButton fab;
    FloatingActionButton fab1;
    FloatingActionButton fab2;
    FloatingActionButton fab3;
    CoordinatorLayout rootLayout;

    int GPS_PERMISSIONS;
    public static LocationManager locMan;
    public static Geocoder geocoder;
    public static LocationListener locListener;

    //Save the FAB's active status
    //false -> fab = close
    //true -> fab = open
    private boolean FAB_Status = false;

    //Animations
    Animation show_fab_1;
    Animation hide_fab_1;
    Animation show_fab_2;
    Animation hide_fab_2;
    Animation show_fab_3;
    Animation hide_fab_3;
    Animation rotate_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_home_screen);

        // Locate the button in activity_main.xml
        Button weatherButton = (Button) findViewById(R.id.WeatherButton);
        weatherButton.setOnClickListener(this);
        locationSetup();
        displayWeather();


        Button calendarButton = (Button) findViewById(R.id.CalendarButton);
        calendarButton.setOnClickListener(this);
        Button alarmButton = (Button) findViewById(R.id.AlarmButton);
        alarmButton.setOnClickListener(this);

        rootLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        //Floating Action Buttons
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);

        //Animations
        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
        show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
        hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);
        rotate_fab = AnimationUtils.loadAnimation(getApplication(), R.anim.fab_rotate);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!FAB_Status) {
                    //Display FAB menu
                    expandFAB();
                    FAB_Status = true;
                } else {
                    //Close FAB menu
                    hideFAB();
                    FAB_Status = false;
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Floating Action Button 1", Toast.LENGTH_SHORT).show();
                Intent newAlarm = new Intent(HomeScreen.this, newAlarm.class);
                startActivity(newAlarm);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Floating Action Button 2", Toast.LENGTH_SHORT).show();
                Intent newCalEvent = new Intent(HomeScreen.this, newCalEvent.class);
                startActivity(newCalEvent);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Floating Action Button 3", Toast.LENGTH_SHORT).show();
                Intent settings = new Intent(HomeScreen.this, SettingsActivity.class);
                startActivity(settings);
            }
        });
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
    private void expandFAB() {

        //Main Floating Action Button
        fab.startAnimation(rotate_fab);
        fab.setClickable(true);

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams1.rightMargin += (int) (fab1.getWidth() * 1.7);
        layoutParams1.bottomMargin += (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams1);
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin += (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin += (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(show_fab_2);
        fab2.setClickable(true);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin += (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(show_fab_3);
        fab3.setClickable(true);
    }


    private void hideFAB() {

        //Main Floating Action Button
        fab.startAnimation(rotate_fab);
        fab.setClickable(true);

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams.rightMargin -= (int) (fab1.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(hide_fab_2);
        fab2.setClickable(false);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(hide_fab_3);
        fab3.setClickable(false);
    }

    public void displayWeather() {
        AsyncTask a = new Weather().execute("current");
        try {
            HashMap<String, String> data = (HashMap<String, String>) a.get();
            String display = "Unable to fetch Weather data";
            Button weather = (Button) findViewById(R.id.WeatherButton);
            if (data != null) display = String.format("%s: \nCurrent Temperature: %s\n %s\n",
                    ProcessJSON.location,data.get("temp"),data.get("condition"));
            weather.setText(display);
            String condition = data.get("condition").toLowerCase().replaceAll(" ","");
            int res = WeatherActivity.getIcon(condition, data.get("day?").equals("true"));
            weather.setCompoundDrawablesWithIntrinsicBounds( 0,
                    0, res, 0 );
        } catch (Exception e) {

        }
    }

    public void locationSetup() {
        locMan = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        geocoder = new Geocoder(this, Locale.getDefault());
        locListener = new MyLocationListener();

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    GPS_PERMISSIONS);
        }
        else {
            locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locMan.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 10, HomeScreen.locListener);

        }
    }
}