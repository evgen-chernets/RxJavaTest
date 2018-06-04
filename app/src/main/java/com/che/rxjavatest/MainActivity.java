package com.che.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    private void test() {

    }
        Observable temperature = new EventEmitter(Observable.OnSubscribe);

        temperature.on('data', data => { 24.2 })
    }
}
