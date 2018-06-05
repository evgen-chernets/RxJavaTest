package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class AirPressure {

    public static String value() {
        String value = "" + (700 + (int)(100 * new Random().nextFloat()));
        Log.d("rxtest", "AirPressure " + value);
        return value;
    }
}
