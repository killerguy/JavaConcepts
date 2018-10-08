package com.mukul.java8features;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    /*
    - The reduction operation combines all elements of the stream into a single result.
    - Java 8 supports three different kind of reduce methods.
     */

    private void simpleReduceExample() {
        List<Person> persons = getPeople();
        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
    }

    private void simpleReduceQithBinaryOperator() {
        Person result = getPeople().stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });

        System.out.format("name=%s; age=%s", result.name, result.age);

        Integer ageSum = getPeople().stream()
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);
    }


    class Person {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    private List<Person> getPeople() {
        return Arrays.asList(
                new Person("Max", 18),
                new Person("Vicky", 23),
                new Person("Ron", 23),
                new Person("Harry", 12));
    }
}
