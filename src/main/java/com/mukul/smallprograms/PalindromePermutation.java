package com.mukul.smallprograms;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() < 2;
    }
}
