package com.mukul.java8features.lambdas.streams;

import com.mukul.java8features.lambdas.domain.Movie;
import com.mukul.java8features.lambdas.util.MovieUtil;

import java.util.List;


/**
 * This class represents some of the functionality of streams
 */
public class DissectingStreams {

    List<Movie> movies = MovieUtil.createMovies();

    /**
     * A method to find the movies directed by a specific director
     *
     * @param director
     */
    private void findMoviesByDirector(String director) {
        movies.stream()
                .filter(m -> m.getDirector().equals(director))
                .map(Movie::getName)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        new DissectingStreams().findMoviesByDirector("Steven Spielberg");
    }

}
