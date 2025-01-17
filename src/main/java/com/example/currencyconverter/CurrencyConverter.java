package com.example.currencyconverter;

public class CurrencyConverter {
    public static double convert(String baseCurrency, String targetCurrency, double amount) throws Exception {
        double exchangeRate = ApiClient.getExchangeRate(baseCurrency, targetCurrency);
        return amount * exchangeRate;
    }
}
