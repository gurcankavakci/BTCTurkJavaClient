package com.kavakci.btcturk.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CancelOrderResult {
    private final boolean result;

    @SerializedName("error")
    @Expose
    private Error error;

    public CancelOrderResult(boolean result) {
        this.result = result;
    }

    public static CancelOrderResult fromJson(String json) {
        Gson g = new Gson();
        return g.fromJson(json,CancelOrderResult.class);
    }

    public boolean isResult() {
        return result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("Cancel Order:").append('\n');
        buf.append("Result: ").append(this.result).append('\n');
        buf.append("\n");

        return buf.toString();
    }
}
