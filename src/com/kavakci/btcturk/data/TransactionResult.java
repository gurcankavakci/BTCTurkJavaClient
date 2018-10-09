package com.kavakci.btcturk.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TransactionResult {
    private final List<Transaction> transactions;

    public TransactionResult(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public static TransactionResult fromJson(String json) {
        Gson g = new Gson();
        Type collectionType = new TypeToken<List<Transaction>>() {}.getType();
        List<Transaction> transactions = g.fromJson(json, collectionType);
        return new TransactionResult(transactions);
    }

    @Override
    public String toString() {
        return "TransactionResult{" +
                "transactions=" + transactions +
                '}';
    }

    public class Transaction {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("operation")
        @Expose
        private String operation;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("funds")
        @Expose
        private Double funds;
        @SerializedName("amount")
        @Expose
        private Double amount;
        @SerializedName("fee")
        @Expose
        private Double fee;
        @SerializedName("tax")
        @Expose
        private Double tax;
        @SerializedName("price")
        @Expose
        private Double price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Double getFunds() {
            return funds;
        }

        public void setFunds(Double funds) {
            this.funds = funds;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public Double getFee() {
            return fee;
        }

        public void setFee(Double fee) {
            this.fee = fee;
        }

        public Double getTax() {
            return tax;
        }

        public void setTax(Double tax) {
            this.tax = tax;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id='" + id + '\'' +
                    ", date='" + date + '\'' +
                    ", operation='" + operation + '\'' +
                    ", currency='" + currency + '\'' +
                    ", funds=" + funds +
                    ", amount=" + amount +
                    ", fee=" + fee +
                    ", tax=" + tax +
                    ", price=" + price +
                    '}';
        }
    }
}
