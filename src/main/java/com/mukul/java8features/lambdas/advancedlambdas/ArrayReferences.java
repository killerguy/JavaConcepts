package com.mukul.java8features.lambdas.advancedlambdas;


import com.mukul.java8features.lambdas.domain.Trade;

/**
 * Class that shows us how to use array references
 *
 */
public class ArrayReferences {
	// Interface creating an array of Strings
	interface StringArray {
		String[] create(int size);
	}

	// Lambda without references
	StringArray sArrayLambda = (size) -> new String[size];

	StringArray sArrayLambdaMethodRef = String[]::new;

	// Trades array
	interface TradeArray {
		Trade[] create(int size);
	}

	// Lambda using array references
	TradeArray tradesLambdaMethodRef = Trade[]::new;
}
