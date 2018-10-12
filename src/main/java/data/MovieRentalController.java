package data;

import logic.model.Movie;
import logic.model.MovieRental;
import logic.repository.MovieRentalRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieRentalController implements MovieRentalRepository {
    @Override
    public void createMovieRental(MovieRental movieRental) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("insert into video_store.movie_rentals (R_Customer_id, R_Movie_id, R_Rental_Date, R_Return_Date, R_Cost) " +
                    "values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, movieRental.getCustomerID());
            preparedStatement.setInt(2, movieRental.getMovieID());
            preparedStatement.setString(3, movieRental.getRentalDate());
            preparedStatement.setString(4, movieRental.getReturnDate());
            preparedStatement.setDouble(5, movieRental.getCost());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<MovieRental> getAllMovieRentals() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select * from video_store.movie_rentals;");

            return transformToMovieRentalList(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    private List<MovieRental> transformToMovieRentalList(ResultSet resultSet) throws SQLException {
        List<MovieRental> movieRentalList = new ArrayList<>();
        while (resultSet.next()) {
            MovieRental movieRental = new MovieRental();
            movieRental.setId(resultSet.getInt("R_Movie_id"));
            movieRental.setCustomerID(resultSet.getInt("R_Customer_id"));
            movieRental.setMovieID(resultSet.getInt("R_Movie_id"));
            movieRental.setRentalDate(resultSet.getString("R_Rental_Date"));
            movieRental.setReturnDate(resultSet.getString("R_Return_Date"));
            movieRental.setCost(resultSet.getDouble("R_Cost"));
            movieRentalList.add(movieRental);
        }
        return movieRentalList;

    }

    private String createConnectionUrl() {
        String host = "localhost";
        String dbName = "video_store";
        String user = "mike";
        String password = "mike";
        return "jdbc:mysql://" + host + "/" + dbName + "?" + "user=" + user + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true";
    }
}
