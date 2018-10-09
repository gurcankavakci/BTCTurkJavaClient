package com.kavakci.btcturk.data.constants;

public enum OrderType {
    BUY("0"),SELL("1");

    private final String s;

    OrderType(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
