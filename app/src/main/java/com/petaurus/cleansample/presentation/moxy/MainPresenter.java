package com.petaurus.cleansample.presentation.moxy;

import android.annotation.SuppressLint;
import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.petaurus.cleansample.domain.UserInteractor;
import com.petaurus.cleansample.presentation.SchedulersProvider;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public static final String TAG = MainPresenter.class.getSimpleName();

    private UserInteractor userInteractor;
    private SchedulersProvider schedulersProvider;

    @Inject
    public MainPresenter(UserInteractor userInteractor, SchedulersProvider schedulersProvider) {
        this.userInteractor = userInteractor;
        this.schedulersProvider = schedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void getRepo(String userName) {
        userInteractor.getUser(userName)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(repos -> {
                    Log.d(TAG, repos.toString());
                }, Throwable::printStackTrace);
    }
}
