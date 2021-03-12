package com.mukul.java8features.lambdas.advancedstreams;

import com.mukul.java8features.lambdas.domain.Trade;
import com.mukul.java8features.lambdas.util.TradeUtil;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stats {

	private void summaryOfTrades() {
		List<Trade> trades = TradeUtil.createTrades();
		IntSummaryStatistics s = trades
			.stream()
			.collect(Collectors.summarizingInt(Trade::getQuantity));
		System.out.println(s);
	}

	private void usingRange() {
		IntStream ints = IntStream.range(10, 20);

		ints.forEach(s -> System.out.print(s+","));
	}

	private void usingRangeClosed() {
		IntStream ints = IntStream.rangeClosed(10, 20);
		ints.forEach(s -> System.out.print(s+","));
	}
	//Min, Max and Average
	private void minMaxAndAverage() {
		IntStream ints = IntStream.rangeClosed(10, 20);
		OptionalInt max = ints.max();
		System.out.println("\nMax: "+max.getAsInt());

		ints = IntStream.rangeClosed(10, 20);
		OptionalInt min = ints.min();
		System.out.println("Min: "+min.getAsInt());

		ints = IntStream.rangeClosed(10, 20);
		OptionalDouble avg = ints.average();
		System.out.println("Min: "+avg.getAsDouble());


	}

	public static void main(String[] args) {
		new Stats().summaryOfTrades();
		new Stats().usingRange();
		new Stats().usingRangeClosed();
		new Stats().minMaxAndAverage();
	}
}
