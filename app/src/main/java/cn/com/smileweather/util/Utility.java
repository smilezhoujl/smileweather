package cn.com.smileweather.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cn.com.smileweather.db.City;
import cn.com.smileweather.db.County;
import cn.com.smileweather.db.Province;

/**
 * Created by jackzhou on 17/3/7.
 */

public class Utility {
    /**
     * 解析和处理服务器端返回的省级数据
     **/
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response) ;
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject = (JSONObject) allProvinces.get(i);
                    Province province = new Province() ;
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save() ;
                }
                return true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false ;
    }

    /**
     * 解析和处理服务器返回的市级数据
     **/
    public static boolean handleCityResponse(String response , int provinceId){

        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response) ;
                for(int i=0;i<allCities.length();i++){
                    JSONObject provinceObject = (JSONObject) allCities.get(i);
                    City city = new City() ;
                    city.setCityName(provinceObject.getString("name"));
                    city.setCityCode(provinceObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save() ;
                }
                return true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false ;
    }

    /**
     * 解析和处理服务器返回的县级数据
     **/
    public static boolean handleCountyResponse(String response , int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response) ;
                for(int i=0;i<allCounties.length();i++){
                    JSONObject provinceObject = (JSONObject) allCounties.get(i);
                    County county = new County() ;
                    county.setCountyName(provinceObject.getString("name"));
                    county.setWeatherId(provinceObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save() ;
                }
                return true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false ;
    }
}
