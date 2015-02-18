package com.richstern.rxsample.model;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by rich on 2/16/15.
 */
public interface ISearchResultService {

    @GET("/search")
    public Observable<SearchResults> getSearchResults(@Query("term") String term);
}
