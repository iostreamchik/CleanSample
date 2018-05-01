package com.petaurus.cleansample.domain;

import com.petaurus.cleansample.data.Repo;
import com.petaurus.cleansample.presentation.SchedulersProvider;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class UserInteractor {

    private UserRepository usersRepository;
    private SchedulersProvider schedulersProvider;

    @Inject
    public UserInteractor(UserRepository usersRepository,
                                 SchedulersProvider schedulersProvider) {
        this.usersRepository = usersRepository;
        this.schedulersProvider = schedulersProvider;
    }


    public Single<List<Repo>> getUser(String username) {
        return usersRepository.getListRepos(username)
                .subscribeOn(schedulersProvider.io());
    }
}
