package cn.com.smileweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jackzhou on 17/3/8.
 */

public class Weather {
    public String status ;

    public Basic basic ;

    public AQI aqi ;

    public Now now ;

    public Suggestion suggestion ;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList ;
}
