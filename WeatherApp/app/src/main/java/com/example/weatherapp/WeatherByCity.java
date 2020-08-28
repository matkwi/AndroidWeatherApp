package com.example.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WeatherByCity {

    private JSONObject weather;
    private String description;
    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;
    private String windSpeed;
    private String clouds;
    private String city;
    private String country;

    public WeatherByCity() {
    }

    public void findWeather(final String city) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=79f3e8f0aacf503557eef33743026204";
                    System.out.println(city);
                    weather = JsonReader.readJsonFromUrl(url);
                    setAll();
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setAll() {
        try {
            setDescription(weather.getJSONArray("weather").getJSONObject(0).getString("description"));
            setTemp(String.valueOf(weather.getJSONObject("main").getDouble("temp")));
            setFeels_like(String.valueOf(weather.getJSONObject("main").getDouble("feels_like")));
            setTemp_min(String.valueOf(weather.getJSONObject("main").getDouble("temp_min")));
            setTemp_max(String.valueOf(weather.getJSONObject("main").getDouble("temp_max")));
            setPressure(String.valueOf(weather.getJSONObject("main").getInt("pressure")));
            setHumidity(String.valueOf(weather.getJSONObject("main").getInt("humidity")));
            setWindSpeed(String.valueOf(weather.getJSONObject("wind").getDouble("speed")));
            setClouds(String.valueOf(weather.getJSONObject("clouds").getInt("all")));
            setCity(weather.getString("name"));
            setCountry(weather.getJSONObject("sys").getString("country"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getTemp() {
        return temp;
    }

    private void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    private void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getTemp_min() {
        return temp_min;
    }

    private void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    private void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getPressure() {
        return pressure;
    }

    private void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    private void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getClouds() {
        return clouds;
    }

    private void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }
}
