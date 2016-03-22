package com.noveo.traineeship.network.services;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by serg on 22.03.16.
 */
public class ServiceFactory {

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit restAdapter = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .build();
        T service = restAdapter.create(clazz);

        return service;
    }
}
