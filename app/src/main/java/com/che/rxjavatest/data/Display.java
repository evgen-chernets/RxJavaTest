package com.che.rxjavatest.data;

import android.util.Log;

/**
 * Created by che on 05.06.18.
 */

public class Display {

    final String temperature;
    final String humidity;
    final String airPressure;

    public Display(String t, String h, String a) {
        temperature = t;
        humidity = h;
        airPressure = a;
    }

    public void logSelf() {
        Log.d("rxtest",
                "\n Display temperature " + temperature +
                        "\n Display humidity " + humidity  +
                        "\n Display airPressure " + airPressure);
    }
}
