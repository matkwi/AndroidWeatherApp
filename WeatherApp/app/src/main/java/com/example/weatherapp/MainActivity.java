package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static boolean firstBoot = true;
    private String capitalCity = "Warsaw";
    private WeatherByCity weatherByCity = new WeatherByCity();
    private TextView temp;
    private TextView feelsLike;
    private TextView city;
    private TextView description;
    private TextView tempMin;
    private TextView tempMax;

    private Bundle bundle = new Bundle();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(firstBoot);

        if(!firstBoot) {
            bundle = getIntent().getExtras();
            if(bundle.getString("City") == null) capitalCity = "Warsaw";
            else capitalCity = bundle.getString("City");
        }

        weatherByCity.findWeather(capitalCity);

        temp = findViewById(R.id.temp);
        feelsLike = findViewById(R.id.feelsLike);
        city = findViewById(R.id.city);
        description = findViewById(R.id.description);
        tempMin = findViewById(R.id.tempMin);
        tempMax = findViewById(R.id.tempMax);

        temp.setText(weatherByCity.getTemp() + "°C");
        feelsLike.setText("Perceived temperature: " + weatherByCity.getFeels_like() + "°C");
        city.setText(weatherByCity.getCity());
        description.setText(weatherByCity.getDescription());
        tempMin.setText("Min temp: " + weatherByCity.getTemp_min() + "°C");
        tempMax.setText("Max temp: " + weatherByCity.getTemp_max() + "°C");


    }

    public void onSearchClick(View view) {
        firstBoot = false;
        Intent intent = new Intent(this, SearchActivity.class);
        bundle.putString("City", capitalCity);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }



}
