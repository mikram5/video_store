package data;

import logic.model.Customer;
import logic.model.Movie;
import logic.repository.MovieRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieController implements MovieRepository {


    @Override
    public void createMovie(Movie movie) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("insert into video_store.Movies (M_title, M_main_actor, M_year, M_genre) " +
                    "values (?, ?, ?, ?)");
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getMainActor());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("There was an error");
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
    public List<Movie> getAllMovies(){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select * from video_store.movies;");

            return transformToMovieList(resultSet);

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

    private List<Movie> transformToMovieList(ResultSet resultSet) throws SQLException {
        List<Movie> movieList = new ArrayList<>();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt("Movie_id"));
            movie.setTitle(resultSet.getString("M_title"));
            movie.setMainActor(resultSet.getString("M_main_actor"));
            movie.setYear(resultSet.getInt("M_year"));
            movie.setGenre(resultSet.getString("M_genre"));
            movieList.add(movie);
        }
        return movieList;

    }

    private String createConnectionUrl() {
        String host = "localhost";
        String dbName = "video_store";
        String user = "mike";
        String password = "mike";
        return "jdbc:mysql://" + host + "/" + dbName + "?" + "user=" + user + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true";
    }
}
