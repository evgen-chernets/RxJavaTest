package com.che.rxjavatest;

import rx.Observable;

/**
 * Created by che on 05.06.18.
 */

class EventEmitter extends Observable {
    /**
     * Creates an Observable with a Function to execute when it is subscribed to.
     * <p>
     * <em>Note:</em> Use {@link #create(OnSubscribe)} to create an Observable, instead of this constructor,
     * unless you specifically have a need for inheritance.
     *
     * @param f {@link OnSubscribe} to be executed when {@link #subscribe(Subscriber)} is called
     */
    protected EventEmitter(OnSubscribe f) {
        super(f);
    }
}
