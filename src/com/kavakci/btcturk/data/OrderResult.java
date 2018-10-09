package com.kavakci.btcturk.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderResult {
    private final String id;
    private final String datetime;
    private final String type;
    private final double price;
    private final double amount;

    @SerializedName("error")
    @Expose
    private Error error;


    public OrderResult(String id, String datetime, String type, double price, double amount) {
        this.id = id;
        this.datetime = datetime;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public static OrderResult fromJson(String json) {
        Gson g = new Gson();
        return g.fromJson(json, OrderResult.class);
    }

    public String getId() {
        return id;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
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

        buf.append("Order Result:").append('\n');
        buf.append("Id: ").append(this.id).append('\n');
        buf.append("Datetime: ").append(this.datetime).append('\n');
        buf.append("Type: ").append(this.type).append('\n');
        buf.append("Price: ").append(this.price).append('\n');
        buf.append("Amount: ").append(this.amount).append('\n');
        buf.append("\n");

        return buf.toString();
    }
}
