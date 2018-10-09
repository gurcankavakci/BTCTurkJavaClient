package com.kavakci.btcturk.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class OpenOrderResult {
    private final List<OpenOrder> openOrders;

    public OpenOrderResult(List<OpenOrder> openOrders) {
        this.openOrders = openOrders;
    }

    public static OpenOrderResult fromJson(String json) {
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<OpenOrder>>(){}.getType();
        List<OpenOrder> openOrders = g.fromJson(json, collectionType);
        return new OpenOrderResult(openOrders);
    }

    public List<OpenOrder> getOpenOrders() {
        return openOrders;
    }

    @Override
    public String toString() {
        return "OpenOrderResult{" +
                "openOrders=" + openOrders +
                '}';
    }

    public static class OpenOrder {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("datetime")
        @Expose
        private String datetime;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("amount")
        @Expose
        private Double amount;
        @SerializedName("pairsymbol")
        @Expose
        private String pairSymbol;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getPairSymbol() {
            return pairSymbol;
        }

        public void setPairSymbol(String pairSymbol) {
            this.pairSymbol = pairSymbol;
        }

        @Override
        public String toString() {
            return "OpenOrder{" +
                    "id='" + id + '\'' +
                    ", datetime='" + datetime + '\'' +
                    ", type='" + type + '\'' +
                    ", price=" + price +
                    ", amount=" + amount +
                    ", pairSymbol='" + pairSymbol + '\'' +
                    '}';
        }
    }
}
