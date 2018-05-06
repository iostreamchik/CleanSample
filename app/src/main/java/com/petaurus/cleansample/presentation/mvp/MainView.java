package com.petaurus.cleansample.presentation.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.petaurus.cleansample.data.Repo;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void initData();

    void showProgress(boolean isShown);

    void setRepoList(List<Repo> repoList);
}
