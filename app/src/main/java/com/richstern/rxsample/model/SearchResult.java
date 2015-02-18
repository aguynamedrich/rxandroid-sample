package com.richstern.rxsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rich on 2/16/15.
 */
public class SearchResult {

    @SerializedName("artistName")
    public String artistName;

    @SerializedName("trackName")
    public String trackName;

    @SerializedName("artworkUrl100")
    public String artworkUrl100;
}
