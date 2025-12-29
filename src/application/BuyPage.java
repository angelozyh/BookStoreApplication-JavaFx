package application;

// @author Rayyan

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class BuyPage implements PageState{
    @Override
    public void changePage(Page page) {
        
        Customer user = null;
        
        if (page.getUser() instanceof Customer) {
            user = (Customer) page.getUser();
        }
        
        Label label1 = new Label("Total Cost: $"+page.getCart().getCost()); 
        label1.setStyle("-fx-font-size: 16px;");
        
        Label label2 = new Label("Points: "+ user.getPoint()); 
        Label label3 = new Label("Status: "+ user.getStatus()); 
        label2.setStyle("-fx-font-size: 16px;");
        label3.setStyle("-fx-font-size: 16px;");
        
        HBox middleHBox = new HBox(10);
        middleHBox.getChildren().addAll(label2, label3);
        middleHBox.setAlignment(Pos.CENTER); 
        
        Button logout = new Button("Logout");
        logout.setPrefWidth(200);
        logout.setStyle("-fx-font-size: 14px;");
        
        logout.setOnAction(event -> {
            page.setPage(new Login());
        });
        
        VBox pageLayout = new VBox(10);
        pageLayout.getChildren().addAll(label1, middleHBox, logout);
        pageLayout.setAlignment(Pos.CENTER); 
        
        Scene loginPage = new Scene(pageLayout, 600, 500);
        page.getPage().setScene(loginPage);
        
    }
}