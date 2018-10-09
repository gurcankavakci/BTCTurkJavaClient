package com.kavakci.btcturk.data.constants;

public enum OrderMethod {
    MARKET_ORDER("1"),LIMIT_ORDER("0"),STOP_MARKET_ORDRE("3");

    private final String orderMethod;

    OrderMethod(String i) {
        this.orderMethod = i;
    }

    @Override
    public String toString() {
        return orderMethod;
    }
}
