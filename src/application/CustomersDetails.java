package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// @author Angelo Huang

public class CustomersDetails {

private ObservableList<Customer> customers = FXCollections.observableArrayList();
  
public void add(Customer person) {
        customers.add(person);
    }

public void remove(Customer person) {
        customers.remove(person);
    }

public ObservableList<Customer> getCustomersList() {
    return customers;
}

}