package application;

//@author ijunaid

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.beans.property.SimpleDoubleProperty;

public class OwnerBookScreen implements PageState{
    
    private Book select;
    
    public void changePage(Page page) {
        
        Books books = Page.getBooksList();
        
        TableView<Book> tableView = new TableView<>();
        TableColumn<Book, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName())
        );

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Book Price");
        priceColumn.setCellValueFactory(cellData -> 
            new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject()
        );
    
        tableView.getColumns().addAll(nameColumn, priceColumn);
        
        tableView.setItems(books.getBooksList());
        
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldBook, newBook) -> {
            if (newBook != null) {
                select = newBook;
                
            }
        });
        
        TextField bookName = new TextField();
        bookName.setPromptText("Book Name");
        TextField bookPrice = new TextField();
        bookPrice.setPromptText("Book Price");
        Button addBook = new Button("Add");
        
        addBook.setOnAction(event -> {
            String nameInput = bookName.getText();
            String priceInput = bookPrice.getText();
            try {
                if (nameInput != null && priceInput !=null && books.copyValidate(nameInput)) {
                    Page.getBooksList().add(new Book(nameInput,Double.parseDouble(priceInput)));
                }
            }catch(NumberFormatException ignored){}
        });
        
        HBox middleHBox = new HBox(10);
        middleHBox.getChildren().addAll(bookName, bookPrice, addBook);
        
        Button delete = new Button("Delete");
        Button back = new Button("Back");       
        
        delete.setOnAction(event -> {
            if (select != null) {
                Page.getBooksList().remove(select);
            }
        });
        
        back.setOnAction(event -> {
            page.setPage(new OwnerStartScreen());
        });
        
        HBox bottomHBox = new HBox(10);
        bottomHBox.getChildren().addAll(delete, back);
        
        VBox pageLayout = new VBox();
        pageLayout.getChildren().addAll(tableView, middleHBox, bottomHBox);
        
        Scene BookScreenPage = new Scene(pageLayout, 700, 550);
        page.getPage().setScene(BookScreenPage);
    }
}