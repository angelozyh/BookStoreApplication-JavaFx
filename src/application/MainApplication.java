package application;

import javafx.application.Application;
import javafx.stage.Stage;

// @author Angelo Huang

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage){
        Owner admin = new Owner("admin","admin");
        Page page = new Page(primaryStage,admin);
        page.start();
    
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}