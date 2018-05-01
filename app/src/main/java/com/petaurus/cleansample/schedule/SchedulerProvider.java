package com.petaurus.cleansample.schedule;

import io.reactivex.Scheduler;

public class SchedulerProvider {

    private Scheduler background;
    private Scheduler foreground;

    public SchedulerProvider(Scheduler background, Scheduler foreground) {
        this.background = background;
        this.foreground = foreground;
    }

    //    public void getSchedulersForObservable
}

