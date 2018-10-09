package com.kavakci.btcturk.client;

import com.kavakci.btcturk.data.*;
import com.kavakci.btcturk.data.constants.OrderMethod;
import com.kavakci.btcturk.data.constants.PairSymbol;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TraderClientBTCImpl implements TraderClient {
    private Logger log = Logger.getLogger(TraderClientBTCImpl.class.getName());

    @Override
    public Optional<TickerResult> getTraderTicker() {
        try {
            return BTCTurkServices.getTicker(BTCTurkServices.getAuthentication());
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderBookResult> getTraderOrderBook(PairSymbol pairSymbol) {
        try {
            return BTCTurkServices.getOrderBook(BTCTurkServices.getAuthentication(), pairSymbol);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<TradeResult> getTraderTrade(PairSymbol pairSymbol, int last) {
        try {
            return BTCTurkServices.getTraderTrades(BTCTurkServices.getAuthentication(), pairSymbol, last);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<TradeResult> getTraderTrade(PairSymbol pairSymbol) {
        return getTraderTrade(pairSymbol, 50);
    }

    @Override
    public Optional<BalanceResult> getTraderBalance() {
        try {
            return BTCTurkServices.getBalance(BTCTurkServices.getAuthentication());
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<TransactionResult> getTraderTransaction() {
        try {
            return BTCTurkServices.getTransaction(BTCTurkServices.getAuthentication());
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<OpenOrderResult> getTraderOpenOrder(PairSymbol pairSymbol) {
        try {
            return BTCTurkServices.getOpenOrder(BTCTurkServices.getAuthentication(), pairSymbol);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<CancelOrderResult> postTraderCancelOrder(String orderId) {
        try {
            log.log(Level.INFO,"Cancel request for order id:"+orderId);
            return BTCTurkServices.postCancelOrder(BTCTurkServices.getAuthentication(), orderId);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderResult> buyTraderOrder(OrderMethod orderMethod, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol) {
        try {
            return BTCTurkServices.buyOrder(BTCTurkServices.getAuthentication(), orderMethod, price, pricePrecision, amount, amountPrecision, total, totalPrecision, triggerPrice, triggerPricePrecision, pairSymbol);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderResult> sellTraderOrder(OrderMethod orderMethod, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol) {
        try {
            return BTCTurkServices.sellOrder(BTCTurkServices.getAuthentication(), orderMethod, price, pricePrecision, amount, amountPrecision, total, totalPrecision, triggerPrice, triggerPricePrecision, pairSymbol);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }


}
