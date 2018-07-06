package com.mukul.java5features;

class A {
	A get() {
		return this;
	}
}

public class CovariantReturnType extends A {

	CovariantReturnType get() {
		return this;
	}

	void message() {
		System.out.println("Welcome to Covariant Return Type");
	}

	public static void main(String args[]) {
		new CovariantReturnType().get().message();
	}
}
