package src;

public class Parent extends Person {

    private String occupation; 
    private ContactInformation contactInfo;

    public Parent(String name, String dob, Sex sex, String occupation, 
    String telNum, String email, String addr){
        super(name,dob,sex);
        contactInfo = new ContactInformation(telNum, email, addr);
        this.occupation = occupation;
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
    
    public String getOccupation(){
        return occupation;
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
