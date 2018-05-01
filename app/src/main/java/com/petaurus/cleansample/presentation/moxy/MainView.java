package com.petaurus.cleansample.presentation.moxy;

import com.arellomobile.mvp.MvpView;
import com.petaurus.cleansample.data.Repo;

import java.util.List;

public interface MainView extends MvpView {
    void showProgress(boolean isShown);
    void setRepoList(List<Repo> repoList);
}
