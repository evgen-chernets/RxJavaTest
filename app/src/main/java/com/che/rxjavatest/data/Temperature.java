package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class Temperature {

    public static String value() {
        String value = "" + (20 + (int) (4 * new Random().nextFloat()));
        Log.d("rxtest", "Temperature " + value);
        return value;
    }
}
