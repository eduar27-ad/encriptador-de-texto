package com.example.currencyconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.print("Ingresa la moneda base (ej. USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa la moneda destino (ej. EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa el monto a convertir: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = CurrencyConverter.convert(baseCurrency, targetCurrency, amount);
            System.out.printf("El monto convertido es: %.2f %s%n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
