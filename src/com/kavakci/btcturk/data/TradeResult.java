package com.kavakci.btcturk.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TradeResult {
    private final List<Trade> trades;

    public TradeResult(List<Trade> trades) {
        this.trades = trades;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public static TradeResult fromJson(String json) {
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<Trade>>() {}.getType();
        List<Trade> trades = g.fromJson(json, collectionType);
        return new TradeResult(trades);
    }

    @Override
    public String toString() {
        return "TradeResult{" +
                "trades=" + trades +
                '}';
    }

    public static class Trade {

        private final String date;
        private final String tid;
        private final double price;
        private final double amount;

        public Trade(String date, String tid, double price, double amount) {
            this.date = date;
            this.tid = tid;
            this.price = price;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public String getTid() {
            return tid;
        }

        public double getPrice() {
            return price;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();

            buf.append("Trade:").append('\n');
            buf.append("Date: ").append(this.date).append('\n');
            buf.append("Trade id: ").append(this.tid).append('\n');
            buf.append("Price: ").append(this.price).append('\n');
            buf.append("Amount: ").append(this.amount).append('\n');

            return buf.toString();
        }
    }
}
