package application;

import javafx.stage.Stage;

// @author Angelo Huang

public class Page {
    private Stage page;
    private PageState pageState;
    private Object user;
    private Buy cart = new Buy(this);
    
    private Owner admin;
    private CustomersDetails list;
    
    private static Books books = new Books();
    private static CustomersDetails customers = new CustomersDetails();
    
    public Object getUser(){
        return user;
    }
    
    public Owner getOwnerInfo(){
        return admin;
    }
    
    public CustomersDetails customerDetailsInfo(){
        return list;
    }
    
    public void setUser(Object user){
        this.user = user;
    }
    
    public static Books getBooksList() {
        return books;
    }
    
    public static CustomersDetails getCustomerList() {
        return customers;
    }
    
    public Buy getCart(){
        return this.cart;
    }
    
    public Page(Stage page, Owner admin){
        this.page = page;
        this.pageState = new Login();
        this.admin = admin;
        this.list = new CustomersDetails();
        this.page.setTitle("Bookstore App");
    }
    
    public void setPage(PageState newPage) {
        this.pageState = newPage;
        pageState.changePage(this);
    }
    
    public Stage getPage() {
        return page;
    }
    
    public void start() {
        pageState.changePage(this);
        page.show();
    }
    
}