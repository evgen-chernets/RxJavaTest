package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class AData {
    public final float airPressure;

    public AData() {
        airPressure = 700 + 100 * new Random().nextFloat();
        Log.d("rxtest", "airPressure " + airPressure);
    }
}
