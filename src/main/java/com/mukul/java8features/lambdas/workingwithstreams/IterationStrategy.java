package com.mukul.java8features.lambdas.workingwithstreams;

import com.mukul.java8features.lambdas.domain.Movie;
import com.mukul.java8features.lambdas.util.MovieUtil;

import java.util.ArrayList;
import java.util.List;



public class IterationStrategy {
    List<Movie> movies = MovieUtil.createMovies();
    List<Movie> top2Classics = new ArrayList<>(10);

    private void externalIteration() {
        for (Movie movie : movies) {
            if (movie.isClassic()) {
                top2Classics.add(movie);
            }
        }
        System.out.println("Top two classics (using external iteration): " + top2Classics);
    }

    private void internalIteration() {
        movies.parallelStream()
                .filter(Movie::isClassic)
                .map(Movie::getName)
                .limit(4)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        new IterationStrategy().externalIteration();
        new IterationStrategy().internalIteration();
    }

}
