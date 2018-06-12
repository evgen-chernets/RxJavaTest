package com.che.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.che.rxjavatest.data.DataSource;
import com.che.rxjavatest.data.Display;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;


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
        return delay < 190 ? delay : 1000 + delay;
    }

    private final ArrayList<String> tDataCollection = new ArrayList<>();
    private final ArrayList<String> hDataCollection = new ArrayList<>();
    private final ArrayList<String> aDataCollection = new ArrayList<>();
    private final ArrayList<Display> displayCollection = new ArrayList<>();

    private final String NA = "N/A";

    private Observable<String> createDataSource(String type) {
        return Observable
                .interval(0, getRandomDelay(), TimeUnit.MILLISECONDS)
                .map(l -> DataSource.getDataByType(type))
                .timeout(1000, TimeUnit.MILLISECONDS)
                .onErrorReturn(error -> NA);
    }

    private void test() {

        Observable<String> tObservable = createDataSource("t");
        tObservable.subscribe(tDataCollection::add);

        Observable<String> hObservable = createDataSource("h");
        hObservable.subscribe(hDataCollection::add);

        Observable<String> aObservable = createDataSource("a");
        aObservable.subscribe(aDataCollection::add);

        Observable.combineLatest(tObservable, hObservable, aObservable, Display::new)
                .throttleLast(1, TimeUnit.SECONDS)
                .subscribe(Display::logSelf);
    }
}
