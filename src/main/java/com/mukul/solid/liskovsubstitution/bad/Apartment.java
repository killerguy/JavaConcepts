package com.mukul.solid.liskovsubstitution.bad;

/**
 * Created by mrk on 4/8/14.
 */
abstract class Apartment {
    public int squareFootage;
    public int numberOfBedrooms;

    abstract void setSquareFootage(int sqft);
}
