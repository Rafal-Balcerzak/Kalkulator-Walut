package com.company;

public class Cube {
    private String currency;
    private double rate;

    public Cube(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }

}
