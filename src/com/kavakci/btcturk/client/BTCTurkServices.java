package com.kavakci.btcturk.client;

import com.kavakci.btcturk.data.*;
import com.kavakci.btcturk.data.constants.OrderMethod;
import com.kavakci.btcturk.data.constants.OrderType;
import com.kavakci.btcturk.data.constants.PairSymbol;
import com.kavakci.btcturk.settings.Constants;
import com.kavakci.btcturk.settings.ServicePrefix;
import net.iharder.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BTCTurkServices {
    /**
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static AuthenticationResult getAuthentication()
            throws IOException,
            InvalidKeyException, NoSuchAlgorithmException {

        String unixTimeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String data = Constants.API_PUBLIC_KEY + unixTimeStamp;

        byte[] secretKey = javax.xml.bind.DatatypeConverter.parseBase64Binary(Constants.API_PRIVATE_KEY);
        SecretKeySpec signingKey = new SecretKeySpec(secretKey, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] bytes = data.getBytes("UTF-8");
        byte[] rawHmac = mac.doFinal(bytes);

        return new AuthenticationResult(unixTimeStamp, Base64.encodeBytes(rawHmac));
    }

    private static String getResponse(HttpURLConnection request) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }


    public static Optional<TickerResult> getTicker(AuthenticationResult authenticationResult) throws IOException {
        String sURL = Constants.API_PREFIX + ServicePrefix.getTickerURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(TickerResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }


    public static Optional<OrderBookResult> getOrderBook(AuthenticationResult authenticationResult, PairSymbol pairSymbol) throws IOException {
        String sURL = Constants.API_PREFIX + MessageFormat.format(ServicePrefix.getOrderBookURL(), pairSymbol);

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(OrderBookResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }


    public static Optional<TradeResult> getTraderTrades(AuthenticationResult authenticationResult, PairSymbol pairSymbol, int last) throws IOException {
        String sURL = Constants.API_PREFIX + MessageFormat.format(ServicePrefix.getTradesURL(), pairSymbol, last);

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(TradeResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<BalanceResult> getBalance(AuthenticationResult authenticationResult) throws IOException {
        String sURL = Constants.API_PREFIX + ServicePrefix.getAccountBalanceURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(BalanceResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<TransactionResult> getTransaction(AuthenticationResult authenticationResult) throws IOException {
        String sURL = Constants.API_PREFIX + ServicePrefix.getUserTransactionURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(TransactionResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<OpenOrderResult> getOpenOrder(AuthenticationResult authenticationResult, PairSymbol pairSymbol) throws IOException {
        String sURL = Constants.API_PREFIX + MessageFormat.format(ServicePrefix.getOpenOrderURL(), pairSymbol);

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(OpenOrderResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<CancelOrderResult> postCancelOrder(AuthenticationResult authenticationResult, String orderId) throws IOException {
        String sURL = Constants.API_PREFIX + ServicePrefix.getCancelOrderURL();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id", String.valueOf(orderId)));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(CancelOrderResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<OrderResult> buyOrder(AuthenticationResult authenticationResult, OrderMethod orderMethod, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol) throws IOException {
        return exchange(authenticationResult, orderMethod, OrderType.BUY, price, pricePrecision, amount, amountPrecision, total, totalPrecision, triggerPrice, triggerPricePrecision, pairSymbol);
    }

    public static Optional<OrderResult> sellOrder(AuthenticationResult authenticationResult, OrderMethod orderMethod, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol) throws IOException {
        return exchange(authenticationResult, orderMethod, OrderType.SELL, price, pricePrecision, amount, amountPrecision, total, totalPrecision, triggerPrice, triggerPricePrecision, pairSymbol);
    }

    private static Optional<OrderResult> exchange(AuthenticationResult authenticationResult, OrderMethod orderMethod, OrderType orderType, String price, String pricePrecision, String amount, String amountPrecision, String total, String totalPrecision, String triggerPrice, String triggerPricePrecision, PairSymbol pairSymbol) throws IOException {
        String sURL = Constants.API_PREFIX + ServicePrefix.getExchangeUrl();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("OrderMethod", orderMethod.toString()));
        params.add(new BasicNameValuePair("OrderType", orderType.toString()));
        params.add(new BasicNameValuePair("Price", price));
        params.add(new BasicNameValuePair("PricePrecision", pricePrecision));
        params.add(new BasicNameValuePair("Amount", amount));
        params.add(new BasicNameValuePair("AmountPrecision", amountPrecision));
        params.add(new BasicNameValuePair("Total", total));
        params.add(new BasicNameValuePair("TotalPrecision", totalPrecision));
        params.add(new BasicNameValuePair("TriggerPrice", triggerPrice));
        params.add(new BasicNameValuePair("TriggerPricePrecision", triggerPricePrecision));
        params.add(new BasicNameValuePair("DenominatorPrecision", "2"));
        params.add(new BasicNameValuePair("PairSymbol", pairSymbol.toString()));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            String response = getResponse(request);
            return Optional.of(OrderResult.fromJson(response));
        } else {
            return Optional.empty();
        }
    }

}
