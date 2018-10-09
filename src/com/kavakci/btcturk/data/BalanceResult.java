package com.kavakci.btcturk.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BalanceResult {

    @SerializedName("try_balance")
    @Expose
    private Double tryBalance;
    @SerializedName("btc_balance")
    @Expose
    private Double btcBalance;
    @SerializedName("eth_balance")
    @Expose
    private Double ethBalance;
    @SerializedName("xrp_balance")
    @Expose
    private Double xrpBalance;
    @SerializedName("ltc_balance")
    @Expose
    private Double ltcBalance;
    @SerializedName("usdt_balance")
    @Expose
    private Double usdtBalance;
    @SerializedName("try_reserved")
    @Expose
    private Double tryReserved;
    @SerializedName("btc_reserved")
    @Expose
    private Double btcReserved;
    @SerializedName("eth_reserved")
    @Expose
    private Double ethReserved;
    @SerializedName("xrp_reserved")
    @Expose
    private Double xrpReserved;
    @SerializedName("ltc_reserved")
    @Expose
    private Double ltcReserved;
    @SerializedName("usdt_reserved")
    @Expose
    private Double usdtReserved;
    @SerializedName("try_available")
    @Expose
    private Double tryAvailable;
    @SerializedName("btc_available")
    @Expose
    private Double btcAvailable;
    @SerializedName("eth_available")
    @Expose
    private Double ethAvailable;
    @SerializedName("xrp_available")
    @Expose
    private Double xrpAvailable;
    @SerializedName("ltc_available")
    @Expose
    private Double ltcAvailable;
    @SerializedName("usdt_available")
    @Expose
    private Double usdtAvailable;
    @SerializedName("btctry_taker_fee_percentage")
    @Expose
    private Double btctryTakerFeePercentage;
    @SerializedName("btctry_maker_fee_percentage")
    @Expose
    private Double btctryMakerFeePercentage;
    @SerializedName("ethtry_taker_fee_percentage")
    @Expose
    private Double ethtryTakerFeePercentage;
    @SerializedName("ethtry_maker_fee_percentage")
    @Expose
    private Double ethtryMakerFeePercentage;
    @SerializedName("ethbtc_taker_fee_percentage")
    @Expose
    private Double ethbtcTakerFeePercentage;
    @SerializedName("ethbtc_maker_fee_percentage")
    @Expose
    private Double ethbtcMakerFeePercentage;
    @SerializedName("xrptry_taker_fee_percentage")
    @Expose
    private Double xrptryTakerFeePercentage;
    @SerializedName("xrptry_maker_fee_percentage")
    @Expose
    private Double xrptryMakerFeePercentage;
    @SerializedName("ltctry_taker_fee_percentage")
    @Expose
    private Double ltctryTakerFeePercentage;
    @SerializedName("ltctry_maker_fee_percentage")
    @Expose
    private Double ltctryMakerFeePercentage;
    @SerializedName("usdttry_taker_fee_percentage")
    @Expose
    private Double usdttryTakerFeePercentage;
    @SerializedName("usdttry_maker_fee_percentage")
    @Expose
    private Double usdttryMakerFeePercentage;

    public static BalanceResult fromJson(String response) {
        Gson g = new Gson();
        return g.fromJson(response, BalanceResult.class );
    }

    public Double getTryBalance() {
        return tryBalance;
    }

    public void setTryBalance(Double tryBalance) {
        this.tryBalance = tryBalance;
    }

    public Double getBtcBalance() {
        return btcBalance;
    }

    public void setBtcBalance(Double btcBalance) {
        this.btcBalance = btcBalance;
    }

    public Double getEthBalance() {
        return ethBalance;
    }

    public void setEthBalance(Double ethBalance) {
        this.ethBalance = ethBalance;
    }

    public Double getXrpBalance() {
        return xrpBalance;
    }

    public void setXrpBalance(Double xrpBalance) {
        this.xrpBalance = xrpBalance;
    }

    public Double getLtcBalance() {
        return ltcBalance;
    }

    public void setLtcBalance(Double ltcBalance) {
        this.ltcBalance = ltcBalance;
    }

    public Double getUsdtBalance() {
        return usdtBalance;
    }

    public void setUsdtBalance(Double usdtBalance) {
        this.usdtBalance = usdtBalance;
    }

    public Double getTryReserved() {
        return tryReserved;
    }

    public void setTryReserved(Double tryReserved) {
        this.tryReserved = tryReserved;
    }

    public Double getBtcReserved() {
        return btcReserved;
    }

    public void setBtcReserved(Double btcReserved) {
        this.btcReserved = btcReserved;
    }

    public Double getEthReserved() {
        return ethReserved;
    }

    public void setEthReserved(Double ethReserved) {
        this.ethReserved = ethReserved;
    }

    public Double getXrpReserved() {
        return xrpReserved;
    }

    public void setXrpReserved(Double xrpReserved) {
        this.xrpReserved = xrpReserved;
    }

    public Double getLtcReserved() {
        return ltcReserved;
    }

    public void setLtcReserved(Double ltcReserved) {
        this.ltcReserved = ltcReserved;
    }

    public Double getUsdtReserved() {
        return usdtReserved;
    }

    public void setUsdtReserved(Double usdtReserved) {
        this.usdtReserved = usdtReserved;
    }

    public Double getTryAvailable() {
        return tryAvailable;
    }

    public void setTryAvailable(Double tryAvailable) {
        this.tryAvailable = tryAvailable;
    }

    public Double getBtcAvailable() {
        return btcAvailable;
    }

    public void setBtcAvailable(Double btcAvailable) {
        this.btcAvailable = btcAvailable;
    }

    public Double getEthAvailable() {
        return ethAvailable;
    }

    public void setEthAvailable(Double ethAvailable) {
        this.ethAvailable = ethAvailable;
    }

    public Double getXrpAvailable() {
        return xrpAvailable;
    }

    public void setXrpAvailable(Double xrpAvailable) {
        this.xrpAvailable = xrpAvailable;
    }

    public Double getLtcAvailable() {
        return ltcAvailable;
    }

    public void setLtcAvailable(Double ltcAvailable) {
        this.ltcAvailable = ltcAvailable;
    }

    public Double getUsdtAvailable() {
        return usdtAvailable;
    }

    public void setUsdtAvailable(Double usdtAvailable) {
        this.usdtAvailable = usdtAvailable;
    }

    public Double getBtctryTakerFeePercentage() {
        return btctryTakerFeePercentage;
    }

    public void setBtctryTakerFeePercentage(Double btctryTakerFeePercentage) {
        this.btctryTakerFeePercentage = btctryTakerFeePercentage;
    }

    public Double getBtctryMakerFeePercentage() {
        return btctryMakerFeePercentage;
    }

    public void setBtctryMakerFeePercentage(Double btctryMakerFeePercentage) {
        this.btctryMakerFeePercentage = btctryMakerFeePercentage;
    }

    public Double getEthtryTakerFeePercentage() {
        return ethtryTakerFeePercentage;
    }

    public void setEthtryTakerFeePercentage(Double ethtryTakerFeePercentage) {
        this.ethtryTakerFeePercentage = ethtryTakerFeePercentage;
    }

    public Double getEthtryMakerFeePercentage() {
        return ethtryMakerFeePercentage;
    }

    public void setEthtryMakerFeePercentage(Double ethtryMakerFeePercentage) {
        this.ethtryMakerFeePercentage = ethtryMakerFeePercentage;
    }

    public Double getEthbtcTakerFeePercentage() {
        return ethbtcTakerFeePercentage;
    }

    public void setEthbtcTakerFeePercentage(Double ethbtcTakerFeePercentage) {
        this.ethbtcTakerFeePercentage = ethbtcTakerFeePercentage;
    }

    public Double getEthbtcMakerFeePercentage() {
        return ethbtcMakerFeePercentage;
    }

    public void setEthbtcMakerFeePercentage(Double ethbtcMakerFeePercentage) {
        this.ethbtcMakerFeePercentage = ethbtcMakerFeePercentage;
    }

    public Double getXrptryTakerFeePercentage() {
        return xrptryTakerFeePercentage;
    }

    public void setXrptryTakerFeePercentage(Double xrptryTakerFeePercentage) {
        this.xrptryTakerFeePercentage = xrptryTakerFeePercentage;
    }

    public Double getXrptryMakerFeePercentage() {
        return xrptryMakerFeePercentage;
    }

    public void setXrptryMakerFeePercentage(Double xrptryMakerFeePercentage) {
        this.xrptryMakerFeePercentage = xrptryMakerFeePercentage;
    }

    public Double getLtctryTakerFeePercentage() {
        return ltctryTakerFeePercentage;
    }

    public void setLtctryTakerFeePercentage(Double ltctryTakerFeePercentage) {
        this.ltctryTakerFeePercentage = ltctryTakerFeePercentage;
    }

    public Double getLtctryMakerFeePercentage() {
        return ltctryMakerFeePercentage;
    }

    public void setLtctryMakerFeePercentage(Double ltctryMakerFeePercentage) {
        this.ltctryMakerFeePercentage = ltctryMakerFeePercentage;
    }

    public Double getUsdttryTakerFeePercentage() {
        return usdttryTakerFeePercentage;
    }

    public void setUsdttryTakerFeePercentage(Double usdttryTakerFeePercentage) {
        this.usdttryTakerFeePercentage = usdttryTakerFeePercentage;
    }

    public Double getUsdttryMakerFeePercentage() {
        return usdttryMakerFeePercentage;
    }

    public void setUsdttryMakerFeePercentage(Double usdttryMakerFeePercentage) {
        this.usdttryMakerFeePercentage = usdttryMakerFeePercentage;
    }

    @Override
    public String toString() {
        return "BalanceResult{" +
                "tryBalance=" + tryBalance +
                ", btcBalance=" + btcBalance +
                ", ethBalance=" + ethBalance +
                ", xrpBalance=" + xrpBalance +
                ", ltcBalance=" + ltcBalance +
                ", usdtBalance=" + usdtBalance +
                ", tryReserved=" + tryReserved +
                ", btcReserved=" + btcReserved +
                ", ethReserved=" + ethReserved +
                ", xrpReserved=" + xrpReserved +
                ", ltcReserved=" + ltcReserved +
                ", usdtReserved=" + usdtReserved +
                ", tryAvailable=" + tryAvailable +
                ", btcAvailable=" + btcAvailable +
                ", ethAvailable=" + ethAvailable +
                ", xrpAvailable=" + xrpAvailable +
                ", ltcAvailable=" + ltcAvailable +
                ", usdtAvailable=" + usdtAvailable +
                ", btctryTakerFeePercentage=" + btctryTakerFeePercentage +
                ", btctryMakerFeePercentage=" + btctryMakerFeePercentage +
                ", ethtryTakerFeePercentage=" + ethtryTakerFeePercentage +
                ", ethtryMakerFeePercentage=" + ethtryMakerFeePercentage +
                ", ethbtcTakerFeePercentage=" + ethbtcTakerFeePercentage +
                ", ethbtcMakerFeePercentage=" + ethbtcMakerFeePercentage +
                ", xrptryTakerFeePercentage=" + xrptryTakerFeePercentage +
                ", xrptryMakerFeePercentage=" + xrptryMakerFeePercentage +
                ", ltctryTakerFeePercentage=" + ltctryTakerFeePercentage +
                ", ltctryMakerFeePercentage=" + ltctryMakerFeePercentage +
                ", usdttryTakerFeePercentage=" + usdttryTakerFeePercentage +
                ", usdttryMakerFeePercentage=" + usdttryMakerFeePercentage +
                '}';
    }
}