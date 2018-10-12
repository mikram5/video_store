package logic.repository;

import logic.model.Movie;

import java.util.List;

public interface MovieRepository {


    void createMovie(Movie movie);

    List<Movie> getAllMovies();
}
