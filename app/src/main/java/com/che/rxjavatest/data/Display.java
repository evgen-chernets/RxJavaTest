package com.che.rxjavatest.data;

/**
 * Created by che on 05.06.18.
 */

public class Display {

    final String temperature;
    final String humidity;
    final String airPressure;

    public Display(String t, String a, String h) {
        temperature = t;
        airPressure = a;
        humidity = h;
    }
}
