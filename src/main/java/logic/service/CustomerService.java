package logic.service;

import logic.model.Customer;
import logic.repository.CustomerRepository;

import java.util.List;


public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
