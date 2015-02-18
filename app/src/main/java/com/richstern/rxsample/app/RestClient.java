package com.richstern.rxsample.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.richstern.rxsample.model.ISearchResultService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by rich on 2/16/15.
 */
public class RestClient {

    private static final String ITUNES_ENDPOINT = "https://itunes.apple.com";

    ISearchResultService searchResultService;

    public RestClient() {
        Gson gson = new GsonBuilder().create();
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ITUNES_ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .build();

        searchResultService = adapter.create(ISearchResultService.class);
    }

    public ISearchResultService getSearchResultService() {
        return searchResultService;
    }
}
