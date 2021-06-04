package com.mukul.enumExample;

public enum EnumDefinition {
    JANUARY("JANUARY", "JAN", 31),
    FEBRUARY("FEBRUARY", "FEB", 28),
    MARCH("MARCH", "MAR", 31),
    APRIL("APRIL", "APR", 30);

    private final String fullName;
    private final String shortName;
    private final int days;

    EnumDefinition(String fullName, String shortName, int days) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.days = days;
    }

    public String getShortName() {
        return shortName;
    }

    public int getDaysOfMonth() {
        return days;
    }

}
