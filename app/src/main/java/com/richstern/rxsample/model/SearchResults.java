package com.richstern.rxsample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rich on 2/16/15.
 */
public class SearchResults {

    @SerializedName("resultCount")
    public int resultCount;

    @SerializedName("results")
    public List<SearchResult> results;
}
