package com.che.rxjavatest.data;

public class DataSource {
    public static String getDataByType(String type) {
        switch (type) {
            case "a" : return AirPressure.value();
            case "h" : return Humidity.value();
            default: return Temperature.value();
        }
    }
}
