package com.petaurus.cleansample.application;

import com.petaurus.cleansample.domain.UserRepository;
import dagger.Component;
import dagger.android.AndroidInjector;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent extends AndroidInjector<App> {

    UserRepository provideUserRepository();

}
