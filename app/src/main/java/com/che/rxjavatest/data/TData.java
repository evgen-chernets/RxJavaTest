package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class TData {
    public final float temperature;

    public TData() {
        temperature = 20 + 4 * new Random().nextFloat();
        Log.d("rxtest", "temperature " + temperature);
    }
}
