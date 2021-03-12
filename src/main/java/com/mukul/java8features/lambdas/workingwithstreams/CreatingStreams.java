package com.mukul.java8features.lambdas.workingwithstreams;

import com.mukul.java8features.lambdas.domain.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreatingStreams {
    private void testEmptyStreams() {
        Stream<Movie> moviesEmptyStream = Stream.empty();
        System.out.println("Number of movies:" + moviesEmptyStream.count());
    }

    private void testStreamsFromValues() {
        Stream<String> movieNames = Stream.of("Gods Must Be Crazy",
                "Fiddler On The Roof", "Ben-Hur");

        movieNames.forEach(System.out::println);

        String[] movieNames2 = {"Gods Must Be Crazy", "Fiddler On The Roof"};
        Stream<String> mNames2 = Stream.of(movieNames2);

        mNames2.forEach(System.out::println);

        List<String> moviesList = new ArrayList<>();
        moviesList.add("The Sound of Music");
        moviesList.add("Gone with the Wind");

        Stream<List<String>> fromList = Stream.of(moviesList);
        fromList.forEach(System.out::println);
    }

    private void testInfiniteStreams() {
        Random rand = new Random();
        Supplier<Integer> randomIntegerSupplier = () -> rand.nextInt(100);

        // Infinite stream of random ints
        Stream<Integer> randomIntStream = Stream
                .generate(randomIntegerSupplier);
        randomIntStream.forEach(System.out::println);

        // Infinite stream of random Doubles
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.forEach(System.out::println);

        // Infinite stream of whole numbers starting from 1
        Stream<Integer> wholeNumbers = Stream.iterate(1, i -> i + 1);
        wholeNumbers.forEach(System.out::println);

    }

    private void testFileStream() throws IOException {


        Stream<String> fileLines = Files.lines(Paths
                .get("pom.xml"));
        fileLines.forEach(System.out::println);

        Path root = Paths.get("pom.xml");
        int maxDepth = Integer.MAX_VALUE;
        BiPredicate<Path, BasicFileAttributes> filter = (path, attrs) -> true;
        Stream<Path> pathStream = Files.find(root, maxDepth, filter);
        pathStream.forEach(System.out::println);

    }

    public static void main(String[] args) throws IOException {
        new CreatingStreams().testEmptyStreams();
        new CreatingStreams().testStreamsFromValues();
       // new CreatingStreams().testInfiniteStreams();
        new CreatingStreams().testFileStream();
    }

}
