package com.mukul.java5features;

import java.util.ArrayList;

public class CollectionGenerics{
	public static void main(String[] args){
		ArrayList<String> list=new ArrayList<>();
		
		list.add("John");
		list.add("Doe");

		String s=list.get(1);//type casting is not required  
		System.out.println("element is: "+s);

		for (String value : list) {
			System.out.println(value);
		}  
	}  
}  
