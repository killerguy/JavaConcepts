package com.mukul.java8features.lambdas.streams;

import com.mukul.java8features.lambdas.domain.Trade;
import com.mukul.java8features.lambdas.util.TradeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This class is used to explain the differences in pre-Java8 and Java 8 style
 * of programming
 */
public class StreamsBasics {
    private final int ONE_MILLION = 1000000;

    private List<Trade> findLargeTradesPreJava8(List<Trade> trades) {
        List<Trade> largeTrades = new ArrayList<>();

        for (Trade trade : trades) {
            if (trade.getQuantity() > ONE_MILLION && trade.isCancelledTrade()) {
                largeTrades.add(trade);
            }
        }
        return largeTrades;
    }

    private List<Trade> findLargeTradesUsingStreams(List<Trade> trades) {
        return trades.stream().filter(trade -> trade.getQuantity() > ONE_MILLION)
                .filter(Trade::isCancelledTrade).collect(Collectors.toList());
    }

    private List<Trade> findLargeTradesUsingParallelStreams(List<Trade> trades) {
        return trades.parallelStream()
                .filter(trade -> trade.getQuantity() > ONE_MILLION)
                .filter(Trade::isCancelledTrade)
                .collect(Collectors.toList());
    }

    private List<Trade> findLargeTradesUsingParallelStreams2(List<Trade> trades,String instrument) {
        return trades.parallelStream()
                .filter(trade -> trade.getQuantity() > ONE_MILLION)
                .filter(trade -> trade.getInstrument().equals(instrument))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Trade> trades = TradeUtil.createTrades();

        List<Trade> largeTrades = new StreamsBasics().findLargeTradesPreJava8(trades);
        System.out.println("Using pre-Java8:" + largeTrades);

        largeTrades = new StreamsBasics().findLargeTradesUsingStreams(trades);
        System.out.println("Using streams:" + largeTrades);

        largeTrades = new StreamsBasics().findLargeTradesUsingParallelStreams(trades);
        System.out.println("Using parallel streams:" + largeTrades);

        largeTrades = new StreamsBasics().findLargeTradesUsingParallelStreams2(trades,"IBM");
        System.out.println("Using parallel streams2 :" + largeTrades);
    }

}
