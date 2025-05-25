package com.tradestream.trade_dashboard.model;

public class Trade {
    private String tradeId;
    private String symbol;
    private String side;
    private double price;
    private int quantity;
    private long timestamp;

    // Default constructor (required for serialization/deserialization)
    public Trade() {}

    // Parameterized constructor (optional for convenience)
    public Trade(String tradeId, String symbol, String side, double price, int quantity, long timestamp) {
        this.tradeId = tradeId;
        this.symbol = symbol;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

