package com.mukul.java8features.lambdas.advancedlambdas;

public class ReferenceUtil {
	
	public boolean isClassic(int movieId) {
		return movieId < 1000;
	}
	
	public static boolean isHorror(int movieId) {
		return movieId > 10000 && movieId < 20000;
	}
}
