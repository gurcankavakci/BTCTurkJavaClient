package com.kavakci.btcturk.test;

import com.kavakci.btcturk.client.TraderClient;
import com.kavakci.btcturk.client.TraderClientBTCImpl;
import com.kavakci.btcturk.data.constants.OrderMethod;
import com.kavakci.btcturk.data.constants.PairSymbol;
import com.kavakci.btcturk.settings.Constants;
import net.iharder.Base64;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TraderTest {
    @Test
    public void connectionTest() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String unixTimeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String data = Constants.API_PUBLIC_KEY + unixTimeStamp;

        byte[] secretKey = javax.xml.bind.DatatypeConverter.parseBase64Binary(Constants.API_PRIVATE_KEY);
        SecretKeySpec signingKey = new SecretKeySpec(secretKey, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] bytes = data.getBytes("UTF-8");
        byte[] rawHmac = mac.doFinal(bytes);

        URL url = new URL("https://www.btcturk.com/api/balance");

        HttpURLConnection request = (HttpURLConnection) url.openConnection();

        request.setRequestMethod("GET");
        request.setRequestProperty("X-PCK", Constants.API_PUBLIC_KEY);
        request.setRequestProperty("X-Stamp", unixTimeStamp);
        request.setRequestProperty("X-Signature", Base64.encodeBytes(rawHmac));
        request.setRequestProperty("User-Agent", "Mozilla/5.0");
        request.setReadTimeout(60 * 1000);
        request.setConnectTimeout(60 * 1000);
        request.setUseCaches(false);
        request.setDoOutput(true);
        request.setDoInput(true);
        request.connect();

        assert request.getResponseCode() == 200;
    }

    @Test
    public void tickerTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderTicker().isPresent();
    }

    @Test
    public void orderBookTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderOrderBook(PairSymbol.BTCTRY).isPresent();
    }

    @Test
    public void traderTradeTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderTrade(PairSymbol.BTCTRY).isPresent();
    }

    @Test
    public void balanceTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderBalance().isPresent();
    }

    @Test
    public void transactionTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderTransaction().isPresent();
    }

    @Test
    public void openOrderTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.getTraderOpenOrder(PairSymbol.BTCTRY).isPresent();
    }

    @Test
    public void cancelOrderTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.postTraderCancelOrder("123").isPresent();
    }

    @Test
    public void buyTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.buyTraderOrder(OrderMethod.LIMIT_ORDER, "10000", "00",
                "0", "00000026", "0", "00", "0", "00", PairSymbol.BTCTRY).isPresent();
    }

    @Test
    public void sellTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        assert btcTraderClient.sellTraderOrder(OrderMethod.LIMIT_ORDER, "100000", "00",
                "0", "0001", "0", "00", "0", "00", PairSymbol.BTCTRY).isPresent();
    }

    @Test
    public void connectionListHasOneBTCTRYTest() {
        TraderClient btcTraderClient = new TraderClientBTCImpl();
        long count = btcTraderClient.getTraderTicker().get().getTickers().stream().filter(ticker -> ticker.getDenominatorsymbol().equals("TRY")).filter(ticker -> ticker.getNumeratorsymbol().equals("BTC")).count();
        assert count == 1;
    }
}
