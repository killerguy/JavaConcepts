package com.mukul.java8features.lambdas.introduction;

import com.mukul.java8features.lambdas.domain.Trade;
import com.mukul.java8features.lambdas.util.TradeUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Streaming {
    private int ONE_MILLION = 1000000;

    private void findLargeTrades(List<Trade> trades) {
        trades.stream()
                .filter(trade -> trade.getQuantity() > ONE_MILLION)
                .forEach(System.out::println);
        ;
    }

    private List<Trade> findLargeTradesInParallel(List<Trade> trades) {
        List<Trade> bigTrades = trades
                .stream()
                .parallel()
                .filter(trade -> trade.getQuantity() > ONE_MILLION)
                .collect(Collectors.toList());

        return bigTrades;
    }


    public static void main(String[] args) {
        List<Trade> trades = TradeUtil.createTrades();
        new Streaming().findLargeTrades(trades);
        List<Trade> bigTrades = new Streaming().findLargeTradesInParallel(trades);
        bigTrades.forEach(System.out::println);

    }
}
