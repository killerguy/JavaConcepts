package com.mukul.java8features.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapExample {

    /*
    * FlatMap transforms each element of the stream into a stream of other objects.
    * So each object will be transformed into zero, one or multiple other objects backed by streams.
    * The contents of those streams will then be placed into the returned stream of the flatMap operation.
    */
    public static void main(String[] args) {
        FlatMapExample flatMapExample = new FlatMapExample();
        flatMapExample.simpleFlatMapExample();
        flatMapExample.singlePipelineFlatMapExample();

    }

    private void simpleFlatMapExample() {

        List<Foo> foos = new ArrayList<>();

        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f -> IntStream.range(1, 4)
                .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

    private void singlePipelineFlatMapExample() {
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " +f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }


    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

}
