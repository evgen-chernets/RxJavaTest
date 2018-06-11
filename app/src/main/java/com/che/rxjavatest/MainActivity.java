package com.che.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.che.rxjavatest.data.AirPressure;
import com.che.rxjavatest.data.Display;
import com.che.rxjavatest.data.Humidity;
import com.che.rxjavatest.data.Temperature;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;


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
        long delay = 100 + (long) (100 * new Random().nextFloat());
        return delay < 195 ? delay : 1000 + delay;
    }

    private ArrayList<String> tDataCollection = new ArrayList<>();
    private ArrayList<String> hDataCollection = new ArrayList<>();
    private ArrayList<String> aDataCollection = new ArrayList<>();

    private final String NA = "N/A";

    private Observable createDataSource(ArrayList<String> list) {
        return Observable
                .interval(0, getRandomDelay(), TimeUnit.MILLISECONDS)
                .timeout(1000, TimeUnit.MILLISECONDS)
                .doOnError(error -> list.add(NA))
                .retry();
    }

    private void test() {


        Observable tObservable = createDataSource(tDataCollection);
//        tObservable.subscribe(value -> tDataCollection.add(Temperature.value()));

        Observable hObservable = createDataSource(hDataCollection);
//        hObservable.subscribe(value -> hDataCollection.add(Humidity.value()));

        Observable aObservable = createDataSource(aDataCollection);
//        aObservable.subscribe(value -> aDataCollection.add(AirPressure.value()));

        Observable.zip(tObservable, aObservable, hObservable, Display::new)
                .take(1).subscribe();
        Observable.combineLatest(tObservable, aObservable, hObservable, Display::new).subscribe();

    }
}
