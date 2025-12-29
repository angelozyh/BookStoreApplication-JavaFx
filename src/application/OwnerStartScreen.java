package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


/**
 *
 * @author ijunaid
 */
public class OwnerStartScreen implements PageState{
    @Override
    public void changePage(Page page) {
        Button btnBook = new Button();
        Button btnCustomer = new Button();
        Button btnLogout = new Button();
        btnCustomer.setText("Customers");
        btnBook.setText("Books");
        btnLogout.setText("Logout");
        btnBook.setPrefWidth(120);
        btnBook.setStyle("-fx-font-size: 16px;");
        btnCustomer.setPrefWidth(120);
        btnCustomer.setStyle("-fx-font-size: 16px;");
        btnLogout.setPrefWidth(120);
        btnLogout.setStyle("-fx-font-size: 16px;");
        
        btnCustomer.setOnAction(event -> {
            page.setPage(new OwnerCustomerScreen());
        });
        
        btnBook.setOnAction(event -> {
            page.setPage(new OwnerBookScreen());
        });
        
        btnLogout.setOnAction(event -> {
            page.setPage(new Login());
        });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(btnBook, btnCustomer, btnLogout);
        
        btnBook.setTranslateY(-50);
        btnCustomer.setTranslateY(0);
        btnLogout.setTranslateY(50);
        Scene scene = new Scene(root, 500, 400);
        
        page.getPage().setScene(scene);
        
    }
}
