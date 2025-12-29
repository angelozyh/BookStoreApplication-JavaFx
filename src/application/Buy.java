package application;

//@author Angelo

import java.util.List;
import java.util.ArrayList;

public class Buy {
    private ArrayList<Book> buyBooks = new ArrayList<Book>();
    private double totalCost;
    private Page page;
    
    public void clearCart(){
        buyBooks.clear();
    }
    
    public Buy(Page page) {
        this.page = page;
    }
    
    public double getCost(){
        return this.totalCost;
    }
    
    public void costCalculation(){
        totalCost = 0;
    
        for(Book b : buyBooks){
            totalCost += b.getPrice();
        }
    }
    
    public void addPoints(){
        int point = (int)Math.floor(totalCost)*10;
        if (page.getUser() instanceof Customer) {
            ((Customer) page.getUser()).addPoint(point);
        }
    }
    
    public void redeemPoints(){
        if (page.getUser() instanceof Customer) {
            Customer user = (Customer) page.getUser();
            int points = user.getPoint();
        
            int pointConversion = points/100;
            
            double costDeduction = Math.min(pointConversion, totalCost);
            
            totalCost -= costDeduction;
            
            if (totalCost < 0) {
                totalCost = 0;
            }
            
            user.setPoint(points - (int)(costDeduction * 100));
        }
    }
    
    public void addCart(){
        for(Book book: Page.getBooksList().getBooksList()){
            if(book.getSelect().isSelected()){
                buyBooks.add(book);
            }         
        }
    }
    
    public void removeFromStore(){
        List<Book> remove = new ArrayList<>();
        for (Book book : buyBooks) {
            for (Book original : Page.getBooksList().getBooksList()) {
                if (book.getName().equals(original.getName())) {
                    remove.add(original);
                }
            }
        }
        Page.getBooksList().getBooksList().removeAll(remove);
    }
    
}
