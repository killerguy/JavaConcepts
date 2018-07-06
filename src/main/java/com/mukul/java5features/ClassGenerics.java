package com.mukul.java5features;

public class ClassGenerics {
	public static void main(String args[]) {
		
		MyGen<Integer> m = new MyGen<Integer>();
		
		m.add(2);
		// m.add("Mukul");//Compile time error
		
		System.out.println(m.get());
		
		MyGen<String> m1 = new MyGen<String>();
		
		m1.add("Mukul");
		// m1.add(2); //Compile time error
		
		System.out.println(m1.get());
	}
}

class MyGen<T> {
	T obj;

	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}