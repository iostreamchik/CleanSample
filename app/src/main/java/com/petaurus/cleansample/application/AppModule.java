package com.petaurus.cleansample.application;

import android.content.Context;
import com.petaurus.cleansample.schedule.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Singleton;

@Module
public class AppModule {

   private final Context context;

    public AppModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    @Singleton
    public SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
