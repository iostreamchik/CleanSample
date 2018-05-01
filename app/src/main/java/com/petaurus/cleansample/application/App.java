package com.petaurus.cleansample.application;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static AppComponent appComponent;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = buildComponent();
    }

    public AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("https://api.github.com/"))
                .build();
    }

    public static Context getInstance() {
        return instance;
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

}
