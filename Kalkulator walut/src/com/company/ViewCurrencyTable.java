package com.company;

import java.util.List;

public class ViewCurrencyTable {

    public static void viewTable(List<Cube> listOfElements) {
        String leftAlignFormat = "| %-8s | %-8.2f |%n";

        System.out.format("-----------|-----------%n");
        System.out.format("| Currency | Rate     |%n");
        System.out.format("-----------|-----------%n");
        for (Cube listOfElement : listOfElements) {
            System.out.format(leftAlignFormat, listOfElement.getCurrency(), listOfElement.getRate());
        }
        System.out.format("-----------|-----------%n");
    }

}
