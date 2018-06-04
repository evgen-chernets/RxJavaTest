package com.che.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.che.rxjavatest.data.AData;
import com.che.rxjavatest.data.HData;
import com.che.rxjavatest.data.TData;

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
        long delay = 100 + (long)(100 * new Random().nextFloat());
        return delay < 190 ? delay : 1000 + delay;
    }

    private void test() {

        Observable<TData> tDataObservable = Observable.just(new TData()).delay(getRandomDelay(), TimeUnit.MILLISECONDS).repeat(100);
        Observable<HData> hDataObservable = Observable.just(new HData()).delay(getRandomDelay(), TimeUnit.MILLISECONDS).repeat(100);
        Observable<AData> aDataObservable = Observable.just(new AData()).delay(getRandomDelay(), TimeUnit.MILLISECONDS).repeat(100);



//        Observable temperature = new EventEmitter(Observable.OnSubscribe);
//
//        temperature.on('data', data => { 24.2 })
    }
}
