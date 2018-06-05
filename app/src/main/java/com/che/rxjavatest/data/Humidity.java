package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class Humidity {

    public static String value() {
        String value = "" + (50 + (int) (10 * new Random().nextFloat()));
        Log.d("rxtest", "Humidity " + value);
        return value;
    }
}
