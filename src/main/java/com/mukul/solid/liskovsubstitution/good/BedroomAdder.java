package com.mukul.solid.liskovsubstitution.good;

import com.mukul.solid.liskovsubstitution.bad.PenthouseSuite;

/**
 * Created by mrk on 4/8/14.
 */
public class BedroomAdder {
    public void addBedroom(PenthouseSuite penthouse) {
        penthouse.numberOfBedrooms += 1;
    }
}
