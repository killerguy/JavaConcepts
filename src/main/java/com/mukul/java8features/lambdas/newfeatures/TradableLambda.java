package com.mukul.java8features.lambdas.newfeatures;

import com.mukul.java8features.lambdas.domain.Trade;

/**
 * This class defines few lambda expressions.
 */
public class TradableLambda {

    /**
     * a functional interface for checking conditions on a given trade,
     * returning boolean value
     *
     * @param <Trade>
     */
    interface Tradable<Trade> {
        boolean check(Trade t);
    }

    /**
     * A method that accepts a Tradable (lambda) along with a Trade instance
     *
     * @param tradable
     * @param trade
     */
    public void checkTrade(Tradable<Trade> tradable, Trade trade) {
        System.out.println("Check: " + tradable.check(trade));
    }

    public static void main(String[] args) {

        Trade trade = new Trade(1, "APPLE", 15000000, "NEW");

        // Check for a big trade
        Tradable<Trade> bigTradeLambda = Trade::isBigTrade;
        new TradableLambda().checkTrade(bigTradeLambda, trade);

        // Check for a cancelled trade
        Tradable<Trade> cancelledLambda = Trade::isCancelledTrade;
        new TradableLambda().checkTrade(cancelledLambda, trade);

        // Check for a new or unknown trade
        Tradable<Trade> newOrUnknownTrade = (t) -> {
            return t.getStatus().equals("NEW") || t.getStatus().equals("UNKNOWN");
        };
        new TradableLambda().checkTrade(newOrUnknownTrade, trade);
    }
}
