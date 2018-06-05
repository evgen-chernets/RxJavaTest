package com.che.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.che.rxjavatest.data.AirPressure;
import com.che.rxjavatest.data.Humidity;
import com.che.rxjavatest.data.Temperature;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        test();
    }

    private long getRandomDelay() {
        long delay = 100 + (long)(100 * new Random().nextFloat());
        return delay < 195 ? delay : 1000 + delay;
    }

    private ArrayList<String> tDataCollection = new ArrayList<>();
    private ArrayList<String> hDataCollection = new ArrayList<>();
    private ArrayList<String> aDataCollection = new ArrayList<>();

    private void test() {
        final String NA = "N/A";

        Subscription tSubscription = Observable.interval(0, getRandomDelay(), TimeUnit.MILLISECONDS)
                .timeout(1000, TimeUnit.MILLISECONDS)
                .doOnError(error -> tDataCollection.add(NA))
                .retry()
                .subscribe(value -> tDataCollection.add(Temperature.value()));


        Subscription hSubscription = Observable.interval(0, getRandomDelay(), TimeUnit.MILLISECONDS)
                .timeout(1000, TimeUnit.MILLISECONDS)
                .doOnError(error -> hDataCollection.add(NA))
                .retry()
                .subscribe(value -> hDataCollection.add(Humidity.value()));

        Subscription aSubscription = Observable.interval(0, getRandomDelay(), TimeUnit.MILLISECONDS)
                .timeout(1000, TimeUnit.MILLISECONDS)
                .doOnError(error -> aDataCollection.add(NA))
                .retry()
                .subscribe(value -> aDataCollection.add(AirPressure.value()));

    }
}
