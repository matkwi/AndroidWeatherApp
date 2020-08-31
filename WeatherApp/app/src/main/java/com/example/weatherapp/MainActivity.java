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

    public static boolean firstBoot = true;
    private String capitalCity = "Torun";
    private WeatherByCity weatherByCity = new WeatherByCity();
    private TextView temp;
    private TextView feelsLike;
    private TextView city;
    private TextView description;

    private Bundle bundle = new Bundle();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(firstBoot);

        if(!firstBoot) {
            bundle = getIntent().getExtras();
            if(bundle.getString("City") == null) capitalCity = "Torun";
            else capitalCity = bundle.getString("City");
        }

        weatherByCity.findWeather(capitalCity);

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
        firstBoot = false;
        Intent intent = new Intent(this, SearchActivity.class);
        bundle.putString("City", capitalCity);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }



}
