package com.petaurus.cleansample.presentation.moxy;


import android.os.Bundle;
import android.util.Log;
import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.petaurus.cleansample.R;
import com.petaurus.cleansample.application.App;
import com.petaurus.cleansample.data.Repo;

import java.util.List;

public class MainActivity extends MvpActivity implements MainView {

    public static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        MainPresenterComponent presenterComponent = DaggerMainPresenterComponent.builder()
                .appComponent(App.getComponent())
                .mainPresenterModule(new MainPresenterModule())
                .build();

        return presenterComponent.getPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.getRepo("iostreamchik");
    }

    @Override
    public void showProgress(boolean isShown) {
        Log.d(TAG, "showProgress: " + isShown);
    }

    @Override
    public void setRepoList(List<Repo> repoList) {
        Log.d(TAG, "setRepoList: " + repoList);
    }
}
