package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        ReadXMLFile readXMLFile = new ReadXMLFile();
        List<Cube> cubeList = readXMLFile.parseXML("eurofxref-daily.xml");
        Cube cube = null;
        String currency;
        double rate = 0;
        String countString = null;
        double count = 0;

        ViewCurrencyTable.viewTable(cubeList);

        while (cube == null) {
            System.out.print("Podaj walutę: ");
            currency = input.nextLine().toUpperCase();

            String finalCurrency = currency;
            cube = cubeList.stream()
                    .filter(c -> finalCurrency.equals(c.getCurrency()))
                    .findFirst()
                    .orElse(null);

            if (cube != null) {
                rate = cube.getRate();
            } else {
                System.out.println("\nWaluta '" + currency + "' jest błędna.");
            }
        }

        while (parseDoubleOrNull(countString) == null) {
            System.out.print("Jaką kwotę chcesz przeliczyć (EUR): ");
            countString = input.nextLine();
            if (parseDoubleOrNull(countString) != null) {
                count = parseDoubleOrNull(countString);
            }else {
                System.out.println("\nPodana kwota jest błędna.");
            }
        }

        System.out.println("Przeliczona kwota: " + String.format("%.2f", count * rate));
    }

    public Double parseDoubleOrNull(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }
}
