package logic.repository;

import logic.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();


}
