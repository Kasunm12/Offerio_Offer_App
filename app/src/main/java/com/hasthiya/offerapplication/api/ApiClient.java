package com.hasthiya.offerapplication.api;

import com.hasthiya.offerapplication.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static ApiClient apiClient;


    private ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance(){
        if (apiClient == null){
            apiClient =  new ApiClient();
        }

        return apiClient;
    }

    public ApiServices getApiService(){
        return retrofit.create(ApiServices.class);
    }
}
