package application;

//@author Rayyan

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class OwnerCustomerScreen implements PageState {

    @Override
    public void changePage(Page page) {
        
        CustomersDetails customers = Page.getCustomerList();
        
        // Table and Columns
        TableView<Customer> table = new TableView<>();

        TableColumn<Customer, String> userColumn = new TableColumn<>("Username");
        userColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUser()));

        TableColumn<Customer, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPass()));

        TableColumn<Customer, Integer> pointColumn = new TableColumn<>("Points");
        pointColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPoint()).asObject());

        table.getColumns().addAll(userColumn, passwordColumn, pointColumn);
        table.setItems(customers.getCustomersList());

        // Inputs
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");

        TextField pointsInput = new TextField();
        pointsInput.setPromptText("Points (edit)");

        // Buttons
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button edit = new Button("Edit");
        Button back = new Button("Back");

        // Events
        add.setOnAction(e -> {
            String user = usernameInput.getText();
            String pass = passwordInput.getText();
            if (!user.isEmpty() && !pass.isEmpty()) {
                Page.getCustomerList().add(new Customer(user, pass));
                page.setPage(new OwnerCustomerScreen());
            }
        });

        delete.setOnAction(e -> {
            Customer selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Page.getCustomerList().remove(selected);
                page.setPage(new OwnerCustomerScreen());
            }
        });

        edit.setOnAction(e -> {
            Customer selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                if (!passwordInput.getText().isEmpty()) {
                    selected.setPass(passwordInput.getText());
                }
                if (!pointsInput.getText().isEmpty()) {
                    try {
                        int pts = Integer.parseInt(pointsInput.getText());
                        selected.setPoint(pts);
                    } catch (NumberFormatException ignored) {}
                }
                page.setPage(new OwnerCustomerScreen());
            }
        });

       back.setOnAction(e -> page.setPage(new OwnerStartScreen()));

        // Layout
        HBox inputRow = new HBox(10, usernameInput, passwordInput, pointsInput);
        HBox buttonRow = new HBox(10, add, edit, delete, back);
        VBox layout = new VBox(10, new Label("Manage Customers"), table, inputRow, buttonRow);

        page.getPage().setScene(new Scene(layout, 700, 550));
    }
}
