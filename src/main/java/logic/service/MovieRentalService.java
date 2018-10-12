package logic.service;

import logic.model.MovieRental;
import logic.repository.MovieRentalRepository;

import java.util.List;

public class MovieRentalService {

    private MovieRentalRepository movieRentalRepository;

    public MovieRentalService(MovieRentalRepository movieRentalRepository) {
        this.movieRentalRepository = movieRentalRepository;
    }

    public void createMovieRental(MovieRental movieRental) {
        movieRentalRepository.createMovieRental(movieRental);
    }

    public List<MovieRental> getAllMovie_rentals() {
        return movieRentalRepository.getAllMovieRentals();
    }
}
