package com.petaurus.cleansample.domain;

import com.petaurus.cleansample.data.Repo;
import io.reactivex.Single;

import java.util.List;

public interface UserRepository {
    Single<List<Repo>> getListRepos(String nick);
}
