package com.mukul.java8features.common;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Map<String, Supplier<String>> map = new HashMap<>();

        map.put("def", () -> getData());

        System.out.println("SupplierExample.main");
        System.out.println(map.get("def").get());
        System.out.println("SupplierExample.main");
    }

    public static String getData() {
        System.out.println("SupplierExample.getData");
        return "Java-Champion";
    }
}
