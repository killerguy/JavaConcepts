package com.mukul.enumExample;

import java.text.MessageFormat;

public class EnumImpl {

    public static void main(String[] args) {

        System.out.println("Value of March: " + EnumDefinition.valueOf("MARCH"));
        System.out.println(MessageFormat.format("Get ShortName for {0} Month: {1}", EnumDefinition.valueOf("MARCH"),
                EnumDefinition.valueOf("MARCH").getShortName()));
        System.out.println("ShortName of January: " + EnumDefinition.JANUARY.getShortName());
        System.out.println("Days of Month for February: " + EnumDefinition.FEBRUARY.getDaysOfMonth());
        System.out.println("Days of Month for APRIL: " + EnumDefinition.APRIL.getDaysOfMonth());
    }
}
