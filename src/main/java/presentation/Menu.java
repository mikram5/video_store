package presentation;

import data.CustomerController;
import logic.model.Customer;
import logic.service.CustomerService;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService(new CustomerController());

    public void greetCustomer() {
        System.out.println("Hello, welcome to Mike's Movies!");
        getCustomerName();
    }

    public Customer getCustomerName() {

        System.out.println("What's your name? ");
        String customerName = scanner.nextLine();
        for (Customer customer : customerService.getAllCustomers()) {
            if (customerName.equals(customer.getName())) {
                return customer;
            }
        }
        System.out.println("You must be a new customer. I'll need to get some information from you.");

        return createCustomer(customerName);
    }

    public Customer createCustomer(String customerName) {
        Customer customer = new Customer();
        customer.setName(customerName);
        System.out.println("What is your address? ");
        customer.setAddress(scanner.nextLine());
        System.out.println("Zip code? ");
        customer.setZip(scanner.nextInt());
        System.out.println("Thank you");
        customerService.createCustomer(customer);
        return customer;
    }


}
