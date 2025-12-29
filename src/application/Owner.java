package application;

//@author ijunaid

public class Owner {
    private String user; 
    private String password;
       
       
     public Owner(String user, String password) {
         this.user = user;
         this.password = password;
     }
    
    public String getUserOwner(){
        return this.user;
    }
    
    public String getPassOwner(){
        return this.password;
    }
}
