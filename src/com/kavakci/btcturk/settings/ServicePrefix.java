package com.kavakci.btcturk.settings;

public class ServicePrefix {
    private static final String TICKER = "ticker";
    private static final String ORDER_BOOK = "orderbook?pairSymbol={0}";
    private static final String TRADES = "trades?pairSymbol={0}&last={1}";
    private static final String OHCL_DATA = "ohcldata";

    private static final String ACCOUNT_BALANCE = "balance";
    private static final String USER_TRANSACTION = "userTransactions?offset=0&limit=25&sort=desc";
    private static final String OPEN_ORDERS = "openOrders?pairSymbol={0}";
    private static final String EXCHANGE_URL = "exchange";
    private static final String BUY_URL = "buy";
    private static final String SELL_URL = "sell";
    private static final String CANCEL_ORDER_URL = "cancelOrder";
    private static final String WITHDRAWAL_MONEY = "WithdrawalMoney";
    private static final String GET_MONEY_WITHDRAWAL_INFO = "WithdrawalMoney";
    private static final String DEPOSIT_MONEY = "DepositMoney";
    private static final String GET_DEPOSIT_MONEY_INFO = "DepositMoney";

    public static String getWithdrawalMoneyURL() {
        return WITHDRAWAL_MONEY;
    }

    public static String getGetMoneyWithdrawalInfo() {
        return GET_MONEY_WITHDRAWAL_INFO;
    }

    public static String getDepositMoney() {
        return DEPOSIT_MONEY;
    }

    public static String getGetDepositMoneyInfo() {
        return GET_DEPOSIT_MONEY_INFO;
    }

    public static String getCancelOrderURL() {
        return CANCEL_ORDER_URL;
    }

    public static String getSellURL() {
        return SELL_URL;
    }

    public static String getExchangeUrl() {
        return EXCHANGE_URL;
    }

    public static String getTickerURL() {
        return TICKER;
    }

    public static String getOrderBookURL() {
        return ORDER_BOOK;
    }

    public static String getTradesURL() {
        return TRADES;
    }

    public static String getOhclDataURL() {
        return OHCL_DATA;
    }

    public static String getAccountBalanceURL() {
        return ACCOUNT_BALANCE;
    }

    public static String getUserTransactionURL() {
        return USER_TRANSACTION;
    }

    public static String getOpenOrderURL() {
        return OPEN_ORDERS;
    }
}
