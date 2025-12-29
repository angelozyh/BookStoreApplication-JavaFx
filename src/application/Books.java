package application;

// @author ijunaid

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Books {
    private ObservableList<Book> books = FXCollections.observableArrayList();
    
    public ObservableList<Book> getBooksList() {
        return books;
    }
    
    public void add(Book book) {
        books.add(book);
    }
    
    public void remove(Book book) {
        books.remove(book);
    }
    
    public boolean copyValidate(String name){
        for(Book book: books){
            if(book.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
}
