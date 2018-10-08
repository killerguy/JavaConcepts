package com.mukul.java8features;

import java.util.*;
import java.util.stream.*;

public class StreamExample {

    /*
     A stream represents a sequence of elements and supports different kind of operations
     to perform computations
     */
    private void streamWithSimpleForEach() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c")).map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    private void findFirstUsingStream() {
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    /*
    Besides regular object streams Java 8 ships with special kinds of streams for working
     with the primitive data types int, long and double.
     It's IntStream, LongStream and DoubleStream
     */
    private void usingPrimitiveStream() {
        IntStream.range(1, 4).forEach(System.out::println);
        DoubleStream.of(2.3, 4.3).forEach(System.out::println);
        LongStream.range(1, 4).forEach(System.out::println);
    }


    /*
    Sometimes it's useful to transform a regular object stream to a primitive stream or vice versa.
    For that purpose object streams support the special mapping operations
     mapToInt(), mapToLong() and mapToDouble
     */
    private void mapToIntUsingStream() {
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
    }

    //Primitive streams can be transformed to object streams via mapToObj():
    private void mapToObjUsingStream() {
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
    }

    private void mapToIntAndObjUsingStream() {
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
    }


    private void procesingOrderUsingStream() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                }).forEach(s -> System.out.println("forEach: " + s));


        boolean match = Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("procesingOrderUsingStream: " + match);

    }

    /*
      Collect is an extremely useful terminal operation to transform the elements of the stream
      into a different kind of result, e.g. a List, Set or Map. Collect accepts a Collector which
      consists of four different operations: a supplier, an accumulator, a combiner and a finisher.
    */

    private void collectUsingStream() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Vicky", 23),
                        new Person("Ron", 23),
                        new Person("Harry", 12));

        List<Person> filtered = persons
                .stream()
                .filter(p -> p.name.startsWith("H"))
                .collect(Collectors.toList());

        System.out.println("collectUsingStream Filtered: " + filtered);
    }


    /*
     - Collect accepts a Collector which consists of four different operations: a supplier, an accumulator, a combiner and a finisher.
     - We can simply determine min, max and arithmetic average age of the persons as well as the sum and count.
    */
    private void collectorOperationInStream() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Vicky", 23),
                        new Person("Ron", 23),
                        new Person("Harry", 12));

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println("Average-Age: " + averageAge);

        IntSummaryStatistics ageSummary = persons.stream()
                .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println("Summarizing Age: " + ageSummary);

        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println("Collectors Joining: " + phrase);

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println("Collectors Mapping: " + map);


        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println("Collectors Collect: " + names);

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

}


