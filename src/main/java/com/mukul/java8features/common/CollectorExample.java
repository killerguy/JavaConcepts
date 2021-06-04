package com.mukul.java8features.common;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectorExample {

    private final Map<Product1Test, Integer> products = new HashMap<>();

    public void add(Product1Test product1Test) {
        add(product1Test, 1);
    }

    public void add(Product1Test product1Test, int quantity) {
        products.merge(product1Test, quantity, Integer::sum);
    }

    public void remove(Product1Test product1Test) {
        products.remove(product1Test);
    }

    public void setQuantity(Product1Test product1Test, int quantity) {
        products.put(product1Test, quantity);
    }

    public Map<Product1Test, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}

class Product1Test {

    private final Long id;
    private final String label;
    private final BigDecimal price;

    public Product1Test(Long id, String label, BigDecimal price) {
        this.id = id;
        this.label = label;
        this.price = price;
    }

}
