package cn.com.smileweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jackzhou on 17/3/8.
 */

public class Basic {
    @SerializedName("city")
    public String cityName ;

    @SerializedName("id")
    public String weatherId ;

    public Update update ;

    public class Update{
        @SerializedName("loc")
        public String updateTime ;
    }
}
