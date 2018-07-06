package com.mukul.java5features;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationExample {
    public static void main(String a[]) {

        Vector<String> lang = new Vector<String>();
        lang.add("JAVA");
        lang.add("JS");
        lang.add("KOTLIN");
        lang.add("GROOVY");
        lang.add("PHP");
        lang.add("PERL");

        Enumeration<String> en = lang.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }
}
