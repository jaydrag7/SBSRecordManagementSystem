package src.business_logic_layer;

import src.util.ContactInformation;
import src.util.EType;
import src.util.Person;
import src.util.Sex;

public class Employee extends Person {

    private EType etype;
    private ContactInformation contactInfo;

    public Employee(String name, String dob, Sex sex, EType etype, String telNum, String email, String address){

        super(name,dob,sex);
        this.contactInfo = new ContactInformation(telNum, email, address);
        this.etype = etype;
    }

    public String getName(){
        return name;
    }   

    public String getDOB(){
        return dob;
    }

    public Sex getSex(){
        return sex;
    }

    public EType getEType(){
        return etype;
    }

    public String telNum(){
        return contactInfo.getTelNum();
    }

    public void changeTelNum(String newNum){
        contactInfo.setTelNum(newNum);
    }

    public String Address(){
        return contactInfo.getAddress();
    }

    public void changeAddress(String newAddress){
        contactInfo.setAddress(newAddress);
    }

    public String Email(){
        return contactInfo.getEmail();
    }

    public void changeEmail(String newEmail){
        contactInfo.setEmail(newEmail);
    }
}
    

