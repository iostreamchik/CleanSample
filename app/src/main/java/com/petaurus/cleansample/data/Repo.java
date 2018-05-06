package com.petaurus.cleansample.data;

import com.petaurus.cleansample.presentation.repo_list.RepoItem;

public class Repo implements RepoItem {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}
