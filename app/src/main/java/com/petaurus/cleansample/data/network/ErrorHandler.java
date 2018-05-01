package com.petaurus.cleansample.data.network;

import com.google.gson.Gson;
import retrofit2.Response;

import javax.inject.Inject;

public class ErrorHandler {

    private Gson gson;

    @Inject
    public ErrorHandler(Gson gson) {
        this.gson = gson;
    }

    public ServerError parseError(Response<?> response) {
        try {
            return gson.fromJson(response.errorBody().string(), ServerError.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            response.errorBody().close();
        }
    }
}
