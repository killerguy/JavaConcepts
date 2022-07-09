package com.mukul.utility;

import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@UtilityClass
public class CollectionsUtils {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList();
        List<String> vegetables = new ArrayList();
        List<String> sprouts = new ArrayList();

        fruits.add("Apple");
        fruits.add("Grapes");

        vegetables.add("Potato");
        vegetables.add("Cabbage");

        sprouts.add("Soybean");
        sprouts.add("Lentils");

        System.out.println(joinLists(fruits,vegetables,sprouts));
    }


    public static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static <K,V> Map.Entry<K,V> entry (K key , V value){
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }

    public static boolean isNotEmpty(Collection<?> collections){
          return !CollectionUtils.isEmpty(collections);
    }

    public static <T,V,R,A> R flatMapping (Collection<T> collection, Function<? super T, Collection<V>> getter, Collector<? super  V, A,R> collector){
        return collection.stream().map(getter).flatMap(Collection::stream).collect(collector);
    }
}
