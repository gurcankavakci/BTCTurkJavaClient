package com.kavakci.btcturk.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.kavakci.btcturk.data.constants.PairSymbol;

import java.lang.reflect.Type;
import java.util.List;

public class TickerResult {

    private final List<Ticker> tickers;

    public TickerResult(List<Ticker> tickers) {
        this.tickers = tickers;
    }

    public static TickerResult fromJson(String json) {
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<Ticker>>(){}.getType();
        List<Ticker> tickers = g.fromJson(json, collectionType);
        return new TickerResult(tickers);
    }

    @Override
    public String toString() {
        return "TickerResult{" +
                "tickers=" + tickers +
                '}';
    }

    public List<Ticker> getTickers() {
        return tickers;
    }

    public Ticker getTicker(PairSymbol pairSymbol){
        return tickers
                .stream()
                .filter(ticker -> pairSymbol.toString().equals(ticker.getPair()))
                .findAny()
                .orElse(null);
    }

    public class Ticker {

        @SerializedName("pair")
        @Expose
        private String pair;
        @SerializedName("high")
        @Expose
        private Double high;
        @SerializedName("last")
        @Expose
        private Double last;
        @SerializedName("timestamp")
        @Expose
        private Double timestamp;
        @SerializedName("bid")
        @Expose
        private Double bid;
        @SerializedName("volume")
        @Expose
        private Double volume;
        @SerializedName("low")
        @Expose
        private Double low;
        @SerializedName("ask")
        @Expose
        private Double ask;
        @SerializedName("open")
        @Expose
        private Double open;
        @SerializedName("average")
        @Expose
        private Double average;
        @SerializedName("daily")
        @Expose
        private Double daily;
        @SerializedName("dailyPercent")
        @Expose
        private Double dailyPercent;
        @SerializedName("denominatorsymbol")
        @Expose
        private String denominatorsymbol;
        @SerializedName("numeratorsymbol")
        @Expose
        private String numeratorsymbol;

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }

        public Double getHigh() {
            return high;
        }

        public void setHigh(Double high) {
            this.high = high;
        }

        public Double getLast() {
            return last;
        }

        public void setLast(Double last) {
            this.last = last;
        }

        public Double getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Double timestamp) {
            this.timestamp = timestamp;
        }

        public Double getBid() {
            return bid;
        }

        public void setBid(Double bid) {
            this.bid = bid;
        }

        public Double getVolume() {
            return volume;
        }

        public void setVolume(Double volume) {
            this.volume = volume;
        }

        public Double getLow() {
            return low;
        }

        public void setLow(Double low) {
            this.low = low;
        }

        public Double getAsk() {
            return ask;
        }

        public void setAsk(Double ask) {
            this.ask = ask;
        }

        public Double getOpen() {
            return open;
        }

        public void setOpen(Double open) {
            this.open = open;
        }

        public Double getAverage() {
            return average;
        }

        public void setAverage(Double average) {
            this.average = average;
        }

        public Double getDaily() {
            return daily;
        }

        public void setDaily(Double daily) {
            this.daily = daily;
        }

        public Double getDailyPercent() {
            return dailyPercent;
        }

        public void setDailyPercent(Double dailyPercent) {
            this.dailyPercent = dailyPercent;
        }

        public String getDenominatorsymbol() {
            return denominatorsymbol;
        }

        public void setDenominatorsymbol(String denominatorsymbol) {
            this.denominatorsymbol = denominatorsymbol;
        }

        public String getNumeratorsymbol() {
            return numeratorsymbol;
        }

        public void setNumeratorsymbol(String numeratorsymbol) {
            this.numeratorsymbol = numeratorsymbol;
        }

        @Override
        public String toString() {
            return "Ticker{" +
                    "pair='" + pair + '\'' +
                    ", high=" + high +
                    ", last=" + last +
                    ", timestamp=" + timestamp +
                    ", bid=" + bid +
                    ", volume=" + volume +
                    ", low=" + low +
                    ", ask=" + ask +
                    ", open=" + open +
                    ", average=" + average +
                    ", daily=" + daily +
                    ", dailyPercent=" + dailyPercent +
                    ", denominatorsymbol='" + denominatorsymbol + '\'' +
                    ", numeratorsymbol='" + numeratorsymbol + '\'' +
                    '}';
        }
    }
}