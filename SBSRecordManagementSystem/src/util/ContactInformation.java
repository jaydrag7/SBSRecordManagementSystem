package src.util;

public class ContactInformation {

    private String telNum;
    private String email;
    private String address;

    public ContactInformation(String tel, String email, String addr){
        this.telNum = tel;
        this.email = email;
        this.address = addr;

    }

    public String getTelNum(){
        return telNum;
    }

    public void setTelNum(String newNum){
        telNum = newNum;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }
    
}
