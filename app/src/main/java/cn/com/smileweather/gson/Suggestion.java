package cn.com.smileweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jackzhou on 17/3/8.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort ;

    @SerializedName("cw")
    public CarWash carWash ;

    public Sport sport ;

    public class Comfort{
        @SerializedName("txt")
        public String info ;

    }

    public class CarWash{
        @SerializedName("txt")
        public String info ;
    }

    public class Sport{
        @SerializedName("txt")
        public String info ;
    }
}
