package com.kavakci.btcturk.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderBookResult {
    @SerializedName("timestamp")
    @Expose
    private Double timestamp;
    @SerializedName("bids")
    @Expose
    private List<List<String>> bids = null;
    @SerializedName("asks")
    @Expose
    private List<List<String>> asks = null;

    public static OrderBookResult fromJson(String response) {
        Gson g = new Gson();
        return g.fromJson(response, OrderBookResult.class);
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public List<List<String>> getBids() {
        return bids;
    }

    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    public List<List<String>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }


}
