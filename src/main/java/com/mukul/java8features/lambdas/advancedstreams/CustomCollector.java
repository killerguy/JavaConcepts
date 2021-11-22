package com.mukul.java8features.lambdas.advancedstreams;
import com.mukul.java8features.lambdas.domain.Trade;
import com.mukul.java8features.lambdas.util.TradeUtil;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


/**
 * Class demonstrating the functionality to create custom collectors
 */
public class CustomCollector {
	List<Trade> trades = TradeUtil.createTrades();

	private void collectToCustomCollector() {
		// A supplier
		Supplier<StringBuilder> supplier = StringBuilder::new;

		// An accumulator
		BiConsumer<StringBuilder, Trade> accumulator = 
				(sb, trade) -> sb.append(trade.getInstrument()).append(",");
				
		// A combiner
		BiConsumer<StringBuilder, StringBuilder> combiner =
				(s1, s2) -> s1.append(s2.toString());
		
		// Putting all together
		StringBuilder results = trades
			.stream()
			.collect(supplier, accumulator, combiner);
		
		System.out.println(results);
		
  	}

	public static void main(String[] args) {
		new CustomCollector().collectToCustomCollector();
	}

}
