
package application;


// @author Angelo Huang

public class Customer {
    private String user;
    private String password;
    private String statusColor;
    private int point = 0;
    
    public Customer(String user, String pass){
        this.user = user;
        this.password = pass;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public String getPass(){
        return this.password;
    }
    
    public void setPass(String pass){
        this.password = pass;
    }
    
    public int getPoint(){
        return this.point;
    }
    
    public void setPoint(int point){
        this.point = point;
    }
    
    public void addPoint(int point){
        this.point += point;
    }
    
    public String getStatus(){
        if(this.point>=1000){
            this.statusColor = "Gold";
        }
        else{
            this.statusColor = "Silver";
        }
        
        return this.statusColor;
    }
}
