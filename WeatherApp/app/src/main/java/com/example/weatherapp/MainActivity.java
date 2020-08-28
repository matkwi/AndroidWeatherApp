package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private JSONObject weatherJS;
    private WeatherByCity weatherByCity = new WeatherByCity();
    private TextView temp;
    private TextView feelsLike;
    private TextView city;
    private TextView description;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherByCity.findWeather("Torun");

        temp = findViewById(R.id.temp);
        feelsLike = findViewById(R.id.feelsLike);
        city = findViewById(R.id.city);
        description = findViewById(R.id.description);

        temp.setText(weatherByCity.getTemp() + "°C");
        feelsLike.setText("Perceived temperature: " + weatherByCity.getFeels_like() + "°C");
        city.setText(weatherByCity.getCity());
        description.setText(weatherByCity.getDescription());
        System.out.println(weatherByCity.getDescription());

    }

    public void onSearchClick(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }



}
