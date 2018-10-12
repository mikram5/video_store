package data;

import logic.model.Customer;
import logic.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerController implements CustomerRepository {

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("insert into video_store.customers (C_Name, C_Address, C_Zip_Code) " +
                    "values (?, ?, ?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setInt(3, customer.getZip());
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
    public List<Customer> getAllCustomers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select * from video_store.customers;");

            return transformToCustomerList(resultSet);

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

    private List<Customer> transformToCustomerList(ResultSet resultSet) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("Customer_id"));
            customer.setName(resultSet.getString("C_name"));
            customer.setAddress(resultSet.getString("C_Address"));
            customer.setZip(resultSet.getInt("C_Zip_Code"));
            customerList.add(customer);
        }
        return customerList;
    }

    private String createConnectionUrl() {
        String host = "localhost";
        String dbName = "video_store";
        String user = "mike";
        String password = "mike";
        return "jdbc:mysql://" + host + "/" + dbName + "?" + "user=" + user + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true";
    }
}
