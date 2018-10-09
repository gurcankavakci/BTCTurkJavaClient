package com.kavakci.btcturk.client;

import com.kavakci.btcturk.data.*;
import com.kavakci.btcturk.data.constants.OrderMethod;
import com.kavakci.btcturk.data.constants.PairSymbol;

import java.util.Optional;

public interface TraderClient {
    Optional<TickerResult> getTraderTicker();

    Optional<OrderBookResult> getTraderOrderBook(PairSymbol pairSymbol);

    Optional<TradeResult> getTraderTrade(PairSymbol pairSymbol, int last);

    Optional<TradeResult> getTraderTrade(PairSymbol pairSymbol);

    // need authentication
    Optional<BalanceResult> getTraderBalance();

    Optional<TransactionResult> getTraderTransaction();

    Optional<OpenOrderResult> getTraderOpenOrder(PairSymbol pairSymbol);

    Optional<CancelOrderResult> postTraderCancelOrder(String orderId);

    Optional<OrderResult> buyTraderOrder(OrderMethod orderMethod, String  price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol);

    Optional<OrderResult> sellTraderOrder(OrderMethod orderMethod, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol);




}
