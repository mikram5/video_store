import data.CustomerController;
import data.MovieController;
import data.MovieRentalController;
import logic.model.Customer;
import logic.model.Movie;
import logic.model.MovieRental;
import logic.repository.CustomerRepository;
import logic.service.CustomerService;
import logic.service.MovieRentalService;
import logic.service.MovieService;
import presentation.Menu;
import sun.applet.resources.MsgAppletViewer;

import java.awt.*;
import java.awt.image.CropImageFilter;

public class Application {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Tom Tolbert");
        customer.setAddress("3809 Acorn Ave");
        customer.setZip(48230);

        CustomerController customerController = new CustomerController();
        CustomerService customerService = new CustomerService(customerController);

        Movie movie = new Movie();
        movie.setTitle("Tootsie");
        movie.setMainActor("Dustin Hoffman");
        movie.setYear(1982);
        movie.setGenre("comedy");

        MovieController movieController = new MovieController();
        MovieService movieService = new MovieService(movieController);

        MovieRental movieRental = new MovieRental();
        movieRental.setCustomerID(3);
        movieRental.setMovieID(2);
        movieRental.setRentalDate("2018-12-12");
        movieRental.setReturnDate("2018-12-13");
        movieRental.setCost(3.50);

        MovieRentalController movieRentalController = new MovieRentalController();
        MovieRentalService movieRentalService = new MovieRentalService(movieRentalController);

//        movieRentalService.createMovieRental(movieRental);
//        System.out.println(movieRentalService.getAllMovie_rentals());

        Menu menu = new Menu();
        menu.greetCustomer();

    }
}
