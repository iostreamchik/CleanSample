package com.petaurus.cleansample.data;

import com.petaurus.cleansample.domain.UserRepository;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final ApiRest apiRest;

    @Inject
    public UserRepositoryImpl(ApiRest apiRest) {
        this.apiRest = apiRest;
    }


    @Override
    public Single<List<Repo>> getListRepos(String nick) {
        return apiRest.listRepos(nick);
    }
}
