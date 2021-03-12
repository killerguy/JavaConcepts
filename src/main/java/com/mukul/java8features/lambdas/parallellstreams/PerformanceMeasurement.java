package com.mukul.java8features.lambdas.parallellstreams;

import com.mukul.java8features.lambdas.domain.Trade;
import com.mukul.java8features.lambdas.util.TradeUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


//Measurement of parallel operations
public class PerformanceMeasurement {

    public void sumTradesInSerial() {
        List<Trade> trades = TradeUtil.createTrades(100);
        Instant start = Instant.now();
        // Sequential mode
        trades.stream()
                .map(Trade::getQuantity)
                .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s", "Aggregating trades took ", d.toMillis(), " ms in Sequential mode");
    }

    public void sumTradesInParallel() {
        List<Trade> trades = TradeUtil.createTrades(100);
        Instant start = Instant.now();
        trades
                .stream()
                .parallel()
                .map(Trade::getQuantity)
                .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s", "\nAggregating trades took ", d.toMillis(), " ms in Parallel mode");
    }

    public static void main(String[] args) {
        new PerformanceMeasurement().sumTradesInSerial();
        new PerformanceMeasurement().sumTradesInParallel();
    }

}
