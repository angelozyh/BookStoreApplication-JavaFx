package application;

// @author Angelo Huang

public class LoginAuthentication {
    public Object authenticate(String user, String pass,Owner info, CustomersDetails listInfo){
        
        if(info.getUserOwner().equals(user) && info.getPassOwner().equals(pass)){
            return info;
        }
        
        for(Customer person : listInfo.getCustomersList()){
            if(person.getUser().equals(user) && person.getPass().equals(pass)){
                return person;
            }
        }
        
        return null;
    }
    
}
