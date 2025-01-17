package com.example.currencyconverter;

import java.net.http.*;
import java.net.URI;
import org.json.JSONObject;

public class ApiClient {
    private static final String API_KEY = "edf66961c0506d5dcec69ac3";
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String url = BASE_URL + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al obtener las tasas de cambio. Verifica las monedas ingresadas.");
        }

        JSONObject json = new JSONObject(response.body());
        return json.getJSONObject("rates").getDouble(targetCurrency);
    }
}
