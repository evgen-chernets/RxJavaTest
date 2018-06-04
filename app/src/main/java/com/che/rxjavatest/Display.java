package com.che.rxjavatest;

/**
 * Created by che on 05.06.18.
 */

public class Display {

    final float temperature;
    final float humidity;
    final float airPressure;

    public Display(float t, float a, float h) {
        temperature = t;
        airPressure = a;
        humidity = h;
    }
}
