
package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

// @author Angelo

public class Login implements PageState{
    @Override
    public void changePage(Page page) {
         
        Label label1 = new Label("Welcome to the BookStore App:");
        label1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        Label label2 = new Label("Username:");
        TextField username = new TextField();        
        username.setPromptText("Enter username");
        label2.setStyle("-fx-font-size: 16px;");
        username.setPrefWidth(200);
        username.setStyle("-fx-font-size: 14px;");
        
        HBox userHBox = new HBox(10);
        userHBox.getChildren().addAll(label2, username);
        userHBox.setAlignment(Pos.CENTER);
        
        Label label3 = new Label("Password:");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");
        
        label3.setStyle("-fx-font-size: 16px;");
        password.setPrefWidth(200);
        password.setStyle("-fx-font-size: 14px;");
        
        HBox passHBox = new HBox(10);
        passHBox.getChildren().addAll(label3, password);
        passHBox.setAlignment(Pos.CENTER);
        
        Button login = new Button("Login");
        login.setPrefWidth(120);
        login.setStyle("-fx-font-size: 16px;");
        
        Label label4 = new Label("Nonvalid username or password!");
        label4.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
        label4.setVisible(false);
        
        VBox pageLayout = new VBox(10);
        pageLayout.getChildren().addAll(label1, userHBox, passHBox,login, label4);
        pageLayout.setAlignment(Pos.CENTER); 
        
        login.setOnAction(event -> {
            String userInput = username.getText();
            String passInput = password.getText();

            Owner ownerInfo = page.getOwnerInfo();
            CustomersDetails customerList = Page.getCustomerList();
            
            LoginAuthentication loginAutheticater = new LoginAuthentication();
            Object check = loginAutheticater.authenticate(userInput, passInput, ownerInfo, customerList);
            
            if(check instanceof Owner){
                page.setUser(check);
                label4.setVisible(false);
                page.setPage(new OwnerStartScreen());
            }
            else if(check instanceof Customer){
                page.setUser(check);
                label4.setVisible(false);
                page.setPage(new CustomerStartScreen());
            }else{
                label4.setVisible(true);
            }
            
        });
        
        Scene loginPage = new Scene(pageLayout, 500, 400);
        page.getPage().setScene(loginPage);
    }
    
}
