package logic.service;

import logic.model.Customer;
import logic.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    private CustomerRepository customerRepositoryMock;
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {

        customerRepositoryMock = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepositoryMock);

    }

    @Test
    public void whenCreateCustomer_shouldCustomerCreated() {

        Customer customer = new Customer();

        customerService.createCustomer(customer);

        verify(customerRepositoryMock).createCustomer(customer);
    }

    @Test
    public void whenGetAllCustomers_shouldReturnAllCustomers() {

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        when(customerRepositoryMock.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> allCustomers = customerService.getAllCustomers();

        assertThat(allCustomers).contains(customer1, customer2);
    }
}
