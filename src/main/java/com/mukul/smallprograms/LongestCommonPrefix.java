package com.mukul.smallprograms;

public class LongestCommonPrefix {
    public static String longestCommonPrefix1(String[] strArray) {
        if (strArray == null || strArray.length == 0) return "";

        String prefix = strArray[0];

        for (int i = 1; i < strArray.length; i++) {
            while (strArray[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,
                        prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String[] strArray) {
        if (strArray == null || strArray.length == 0) return "";

        // find minimum length among strings and validate non-null elements
        int minLen = Integer.MAX_VALUE;
        for (String s : strArray) {
            if (s == null) return "";
            minLen = Math.min(minLen, s.length());
        }
        if (minLen == 0) return "";

        // compare characters column-wise up to minLen
        for (int i = 0; i < minLen; i++) {
            char c = strArray[0].charAt(i);
            for (int j = 1; j < strArray.length; j++) {
                if (strArray[j].charAt(i) != c) {
                    return strArray[0].substring(0, i);
                }
            }
        }
        return strArray[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println("Method 1: "+longestCommonPrefix(arr));
        System.out.println("Method 2: "+longestCommonPrefix1(arr));
    }
}
