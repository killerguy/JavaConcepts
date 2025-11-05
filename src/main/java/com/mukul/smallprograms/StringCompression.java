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
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public String decompress(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (i >= s.length()) break; // malformed input
            char c = s.charAt(i++);
            if (count == 0) count = 1;
            for (int j = 0; j < count; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress("aabcccccaaa")); // 2a1b5c3a
        System.out.println(stringCompression.compress("abc")); // abc

        System.out.println("String Compression for aaAAaa: " + stringCompression.compress("aaAAaa")); // 2a2A2a
        System.out.println("String Compression for aabcccccaaa: " + stringCompression.compress("aabcccccaaa")); // 2a1b5c3a
        System.out.println("String Compression for abc: " + stringCompression.compress("abc")); // abc

        System.out.println("String D for abc: " + stringCompression.decompress("2a1b5c3a")); // abc
    }
}
