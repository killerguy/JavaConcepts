package com.mukul.java7features;

import java.text.DecimalFormat;

public class BigDecimalExample {

    public static void main(String[] args) {
        String angle = "0091.8842";

        DecimalFormat df = new DecimalFormat("#0.00");
        String formattedValue = df.format(Double.valueOf(angle));
        System.out.println(formattedValue);
    }
}
