package com.petaurus.cleansample.presentation.mvp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
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
    private Handler handler;

    @Inject
    public MainPresenter(UserInteractor userInteractor, SchedulersProvider schedulersProvider) {
        this.userInteractor = userInteractor;
        this.schedulersProvider = schedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initData();
    }

    @SuppressLint("CheckResult")
    public void getRepos(String userName) {
        userInteractor.getListRepos(userName)
                .doOnSubscribe(disposable -> showProgressWithDelay(true, 300))
                .doFinally(() -> showProgress(false))
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(repos -> getViewState().setRepoList(repos), Throwable::printStackTrace);
    }

    private void showProgress(boolean isShown) {
        showProgressWithDelay(isShown, 0);
    }

    private void showProgressWithDelay(boolean isShown, final long mills) {
        if (handler == null)
            handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacksAndMessages(null);
        if (isShown) {
            handler.postDelayed(() -> getViewState().showProgress(true), mills);
        } else {
            getViewState().showProgress(false);
        }
    }
}
