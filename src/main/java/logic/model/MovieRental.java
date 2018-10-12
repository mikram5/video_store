package logic.model;

public class MovieRental {

    private int id;
    private int customerID;
    private int movieID;
    private String rentalDate;
    private String returnDate;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MovieRental{" +
                "id=" + id +
                ", customerID=" + customerID +
                ", movieID=" + movieID +
                ", rentalDate='" + rentalDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", cost=" + cost +
                '}';
    }
}
