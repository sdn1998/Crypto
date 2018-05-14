package com.example.sudindev.crypto;

public class CryptoCurrency {
    String name;
    String usd;
    String percent;

    public String getName() {
        return name;
    }

    public String getUsd() {
        return usd;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public void setUsd(String usd) {

        this.usd = usd;
    }

    public void setName(String name) {

        this.name = name;
    }
}
