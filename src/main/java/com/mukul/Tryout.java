package com.mukul;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;

public class Tryout {

    public static void main(String[] args) {
        String abc = "{\n" +
                "  \"values\":[\"PCAMAM\",\"PCMAG\"]\n" +
                "}" ;
        System.out.println(convertJSONStringToObject(abc, ArrayList.class));
    }

    public static <T> T convertJSONStringToObject(String jsonFormattedString, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(jsonFormattedString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
