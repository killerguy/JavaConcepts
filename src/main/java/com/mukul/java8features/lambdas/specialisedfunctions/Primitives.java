package com.mukul.java8features.lambdas.specialisedfunctions;

import com.mukul.java8features.lambdas.domain.Trade;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;


/**
 * Class that demonstrates Predicate function usage
 */
public class Primitives {

    int tradeQuantity = 10;

    Function<Integer, Integer> tradeQuantityLambda = id -> {
        Trade t = getTrade(id);
        return t.getQuantity();
    };

    // The redundant type vanishes
    private UnaryOperator<Integer> unaryOperator = (id) -> {
        return tradeQuantity;
    };

    private Trade getTrade(Integer id) {
        return new Trade(id);
    }


    private void binaryOp() {
        BinaryOperator<Integer> sumOfQuantities = (quantity1, quantity2) -> quantity1 + quantity2;
        int result = sumOfQuantities.apply(30000, 44000);
        System.out.println("Sum total: " + result);
    }

    public static void main(String[] args) {
        new Primitives().binaryOp();
        System.out.println(new Primitives().unaryOperator.apply(500));
        System.out.println(new Primitives().tradeQuantityLambda.apply(500));
    }
}
