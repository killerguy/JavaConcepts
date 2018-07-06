package com.mukul.java5features;

import java.util.*; 


public class CollectionGenerics{  
	public static void main(String args[]){  
		ArrayList<String> list=new ArrayList<String>(); 
		
		list.add("Karishma");  
		list.add("Ravina");  


		String s=list.get(1);//type casting is not required  
		System.out.println("element is: "+s);  

		Iterator<String> itr=list.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
	}  
}  
