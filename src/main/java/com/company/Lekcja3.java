package com.company;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class coord {
    long lon;
    long lat;

    public coord() {
        lat = 0;
        lon = 0;
    }
}

class weather {
    long id;
    String main;
    String description;
    String icon;

    public weather(long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}

class main1 {
    double temp;
    double feels_like;
    double temp_min;
    double temp_max;
    long pressure;
    long humidity;

    public main1(double temp, double feels_like, double temp_min, double temp_max, long pressure, long humidity) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}

class wind {
    double speed;
    long deg;

    public wind(double speed, long deg) {
        this.speed = speed;
        this.deg = deg;
    }
}

class clouds {
    long all;

    public clouds(long all) {
        this.all = all;
    }
}

class sys {
    long type;
    long id;
    String country;
    long sunrise;
    long sunset;

    public sys(long type, long id, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}

class Weathermap {
    coord coord;
    weather[] weather;
    String base;
    main1 main;
    long visibility;
    wind wind;
    clouds clouds;
    long dt;
    sys sys;
    long timezone;
    long id;
    String name;
    long cod;

    public Weathermap(com.company.coord coord, com.company.weather[] weather, String base, main1 main, long visibility, com.company.wind wind, com.company.clouds clouds, long dt, com.company.sys sys, long timezone, long id, String name, long cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }
}


public class Lekcja3 {
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        String get = getHTML("https://api.openweathermap.org/data/2.5/weather?q=Lublin&appid=145b42a36b604da62f3b6bf91edd0567");
        Weathermap output = gson.fromJson(get, Weathermap.class);
        System.out.println(get);
        System.out.println(gson.toJson(output));
    }
}
