package com.mukul.solid.liskovsubstitution.good;

import com.mukul.solid.liskovsubstitution.bad.PenthouseSuite;
import com.mukul.solid.liskovsubstitution.good.BedroomAdder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/8/14.
 */
public class BedroomAdderTest {
    @Test
    public void testAddsBedroomToPenthouse() {
        PenthouseSuite penthouse = new PenthouseSuite();
        BedroomAdder adder = new BedroomAdder();
        adder.addBedroom(penthouse);

        assertEquals(5, penthouse.numberOfBedrooms);
    }
}
