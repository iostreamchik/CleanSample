package com.petaurus.cleansample.presentation.mvp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.petaurus.cleansample.R;
import com.petaurus.cleansample.application.App;
import com.petaurus.cleansample.data.Repo;
import com.petaurus.cleansample.presentation.repo_list.RepoItem;
import com.petaurus.cleansample.presentation.repo_list.ReposAdapter;

import java.util.List;

public class MainActivity extends MvpActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    ProgressDialog progressDialog;

    RecyclerView rvMain;
    ReposAdapter reposAdapter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        MainPresenterComponent presenterComponent = DaggerMainPresenterComponent.builder()
                .appComponent(App.getComponent())
                .build();

        return presenterComponent.getPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");

        reposAdapter = new ReposAdapter(new ReposAdapter.OnEventListener() {
            @Override
            public void onClick(int position, RepoItem item) {

            }

            @Override
            public void onItemsSizeChange(boolean isEmpty) {

            }
        });

        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(reposAdapter);
    }

    @Override
    public void initData() {
        presenter.getRepos("JakeWharton");
    }

    @Override
    public void showProgress(boolean isShown) {
        if (isShown)
            progressDialog.show();
        else
            progressDialog.dismiss();
    }

    @Override
    public void setRepoList(List<Repo> repoList) {
        reposAdapter.setItems(repoList);
    }
}
