package com.petaurus.cleansample.presentation.moxy;

import com.petaurus.cleansample.application.AppComponent;
import com.petaurus.cleansample.scope.Presenter;
import dagger.Component;

@Presenter
@Component(dependencies = AppComponent.class, modules = MainPresenterModule.class)
public interface MainPresenterComponent {

    MainPresenter getPresenter();

}
