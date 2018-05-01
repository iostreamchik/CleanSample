package com.petaurus.cleansample.data;

public class Repo {

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
