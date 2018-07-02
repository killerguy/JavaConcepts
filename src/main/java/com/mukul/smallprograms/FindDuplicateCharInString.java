package com.mukul.smallprograms;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCharInString {

    public static void main(String[] args) {
        System.out.println(findFirstDuplicateCharacter());
    }

    public static String findFirstDuplicateCharacter() {
        String src = "mukul";

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char data : src.toCharArray()) {

            if (map.containsKey(data)) {

                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return String.valueOf(entry.getKey());
            }
        }
        return "Not Found";
    }
}
