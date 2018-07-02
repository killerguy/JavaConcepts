package com.mukul.smallprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateElementFromList {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("M");
        list.add("A");
        list.add("B");
        list.add("M");
        list.add("B");
        list.add("z");
        list.add("P");

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : list) {
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        System.out.println(map);

    }
}
