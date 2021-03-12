package com.mukul.java8features.lambdas.introduction;

import com.mukul.java8features.lambdas.domain.Movie;
import com.mukul.java8features.lambdas.util.MovieUtil;

import java.util.List;


/**
 * This class defines few lambda expressions.
 */
public class Examples {
    private void fetchMovies(List<Movie> movies, String director) {
        movies
                .stream()
                .filter(m -> m.getDirector().equals(director))
                .map(Movie::getName)
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Movie> movies = MovieUtil.createMovies();
        new Examples().fetchMovies(movies, "Steven Spielberg");
    }

}
