package com.mukul.java8features.lambdas.newfeatures;

import com.mukul.java8features.lambdas.domain.Movie;
import com.mukul.java8features.lambdas.util.MovieUtil;

import java.util.List;

import static java.util.stream.Collectors.toList;


/**
 * Example for demontrating streams feature
 */
public class ParallelStreamsFeature {

    /**
     * Finding classics running parallel
     *
     * @param movies
     * @return
     */
    public List<Movie> findClassics(List<Movie> movies) {
        return movies
                .stream()
                .parallel()
                .filter(m -> m.isClassic())
                .collect(toList());
    }

    /**
     * Finding classics using parallelStream
     *
     * @param movies
     * @return
     */
    public List<Movie> findClassics2(List<Movie> movies) {
        return movies
                .parallelStream()
                .filter(m -> m.isClassic())
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieUtil.createMovies();
        List<Movie> classics = new ParallelStreamsFeature().findClassics(movies);
        classics.forEach(System.out::println);
    }
}
