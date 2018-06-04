package com.che.rxjavatest.data;

import android.util.Log;

import java.util.Random;

/**
 * Created by che on 05.06.18.
 */

public class HData {
    public final float humidity;

    public HData() {
        humidity = 50 + 10 * new Random().nextFloat();
        Log.d("rxtest", "humidity " + humidity);
    }
}
