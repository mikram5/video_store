package logic.service;

import logic.model.Movie;
import logic.repository.MovieRepository;

import java.util.List;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovie(Movie movie) {
        movieRepository.createMovie(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
}
