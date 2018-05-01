package com.petaurus.cleansample.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiRest {
    @GET("users/{user}/repos")
    Single<List<Repo>> listRepos(@Path("user") String user);
}
