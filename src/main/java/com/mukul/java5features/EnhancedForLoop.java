package com.mukul.java5features;

import java.util.ArrayList;
import java.util.List;

public class EnhancedForLoop {
	public static void main(String[] args) {
		List<String> aList = new ArrayList<>();

		aList.add("Gabbar");
		aList.add("Jaykant Sikhare");
		aList.add("CrimeMaster Gogo");
		aList.add("Mogambo");
		aList.add("Shakaal");
		aList.add("Jageera");

		System.out.println("Listing Using Enhanced For Loop :");
		System.out.println("************************************************");
		
		for(String str: aList){
			System.out.println(str);
		}
		
		System.out.println("************************************************");
	}
}
