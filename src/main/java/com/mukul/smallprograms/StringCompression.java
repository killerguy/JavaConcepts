package com.mukul.smallprograms;

public class StringCompression {

    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count).append(s.charAt(i));
                count = 0;
            }
        }
        System.out.println("String Compress: "+sb.toString());
        return sb.length() < s.length() ? sb.toString() : s;
    }
}
