package logic.repository;


import logic.model.MovieRental;

import java.util.List;

public interface MovieRentalRepository {


    void createMovieRental(MovieRental movieRental);

    List<MovieRental> getAllMovieRentals();
}
