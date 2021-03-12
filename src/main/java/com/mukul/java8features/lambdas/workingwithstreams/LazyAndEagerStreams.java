package com.mukul.java8features.lambdas.workingwithstreams;

import com.mukul.java8features.lambdas.domain.Movie;
import com.mukul.java8features.lambdas.util.MovieUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class demonstrates the lazy and eager characteristics of streams
 */
public class LazyAndEagerStreams {
    List<Movie> movies = MovieUtil.createMovies();

    /**
     * Lazy intermediate operations
     */
    private void lazyIntermediateOperator() {

        // The filter is never executed
        Stream<Movie> movieStream = movies
                .stream()
                .filter(m -> {
                    System.out.println("Lazy operation");
                    return m.isClassic();
                }).limit(2);

        // Unless we add a terminal operator - uncomment and rerun
        // movieStream.forEach(System.out::println);
    }

    /**
     * Eager terminal operations
     */
    private void eagerTerminalOperator() {
        movies
                .stream()
                .filter(m -> {
                    System.out.println("Filtering");
                    return m.isClassic();
                })
                .map(s -> {
                    System.out.println("Mapping");
                    return s;
                })
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
      //  new LazyAndEagerStreams().eagerTerminalOperator();
        System.out.println("-----------------------------------");
        new LazyAndEagerStreams().lazyIntermediateOperator();
    }

}
