package com.noveo.traineeship.network.api;

import com.noveo.traineeship.network.models.News;

import retrofit.http.GET;
import rx.Observable;

public interface Api {
    public static final String END_POINT = "http://androidtraining.noveogroup.com/news";
    public static final String ALL_NEWS = "/getAll";

    @GET(ALL_NEWS)
    Observable<News> listNews();
}
