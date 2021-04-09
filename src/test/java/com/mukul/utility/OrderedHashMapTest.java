package com.mukul.utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class OrderedHashMapTest {

    @Test
    public void shouldReturnOrderedValue(){
        OrderedHashMap< String,String> orderedHashMap = new OrderedHashMap<>();

        orderedHashMap.put("1", "Mukul");
        orderedHashMap.put("2", "abv");
        orderedHashMap.put("3", "ws");
        orderedHashMap.put("4", "qaz");
        orderedHashMap.put("7", "zz");
        orderedHashMap.put("6", "z");
        orderedHashMap.put("5", "zz");


        Assert.assertEquals("Mukul",orderedHashMap.get("1"));

    }

}
