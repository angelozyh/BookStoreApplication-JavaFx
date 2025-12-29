package application;

//@author Angelo

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;


public class CustomerStartScreen implements PageState{
    
    private Customer user;
    
    @Override
    public void changePage(Page page){
        Books books = Page.getBooksList();
        
        if(page.getUser() instanceof Customer){
            user = (Customer)page.getUser();
        }
            
        Label label1 = new Label("Welcome "+user.getUser()+". You have "+user.getPoint()+" points. Your status is "+user.getStatus()+".");
        
        TableView<Book> tableView = new TableView<>();
                
        TableColumn<Book, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName())
        );

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Book Price");
        priceColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPrice())
        );
        
        TableColumn selectColumn = new TableColumn("Select");
        
        selectColumn.setCellValueFactory(
                new PropertyValueFactory<Book, String>("select")
        );
 
        selectColumn.setEditable(true); 
        
        tableView.getColumns().addAll(nameColumn, priceColumn, selectColumn);
        
        tableView.setItems(books.getBooksList());
        
        Button buy = new Button("Buy");
        Button pointBuy = new Button("Redeem points and Buy");
        Button logout = new Button("Logout");
        
        buy.setOnAction(event -> {
            page.getCart().clearCart();
            page.getCart().addCart();
            page.getCart().costCalculation();
            page.getCart().addPoints();
            page.getCart().removeFromStore();
            page.setPage(new BuyPage());
        });
        
        pointBuy.setOnAction(event -> {
            page.getCart().clearCart();
            page.getCart().addCart();
            page.getCart().costCalculation();
            page.getCart().redeemPoints();
            page.getCart().removeFromStore();
            page.setPage(new BuyPage());
        });
        
        logout.setOnAction(event -> {
            page.setPage(new Login());
        });
        
        HBox bottomHBox = new HBox(10);
        bottomHBox.getChildren().addAll(buy, pointBuy, logout);
        
        VBox pageLayout = new VBox();
        pageLayout.getChildren().addAll(label1, tableView, bottomHBox);
        
        Scene scene = new Scene(pageLayout, 800, 600);
        page.getPage().setScene(scene);
        
    }
}
