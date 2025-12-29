package application;

import javafx.scene.control.CheckBox;

// @author ijunaid

public class Book{    
    private CheckBox select;
    
    private String name; 
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
        this.select = new CheckBox();
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect(CheckBox select){
        this.select = select;
    }
    
}
