package src.business_logic_layer.student;

import src.business_logic_layer.Parent;
import src.util.*;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.concurrent.atomic.AtomicInteger;




public class Student extends Person {

    private Parent parent;
    private Parent parent2;
    //private static AtomicInteger ID=new AtomicInteger();
    private int stdID;

    
    
    private ReportCard rptcard;
    private MedicalRecord medicalHistory;
    

    public Student(int stdID,String name,String dob, Sex sex,String pname, String pdob, Sex psex,
    String poccupation,String pTel,String pAddr, String pEmail,String p2name,String p2dob,
    Sex p2sex, String p2_occupation,String p2Tel,String p2Addr, String p2Email,int year, 
    String term, HashMap<String, Integer> grades, ArrayList<String> illnesses,ArrayList<String> allergies,
     HashMap<String,String> permissions,ArrayList<String> injuries,
    String doctorName){

        super(name,dob,sex);
        this.parent=new Parent(pname,pdob,psex,poccupation,pTel,pEmail,pAddr);
        this.parent2=new Parent(p2name,p2dob,p2sex, p2_occupation, p2Tel,p2Email,p2Addr);
        this.rptcard = new ReportCard(year, term, grades);
        this.stdID = stdID;
        medicalHistory = new MedicalRecord(stdID,name,illnesses, allergies, permissions, injuries, doctorName);
    }

    public String getName(){
        return medicalHistory.getStd();
    }

    public int getStdID(){
        return stdID;
    }

    public String getDoc(){
        return medicalHistory.getDoctor();
    }

    public String illnesses(){
        return medicalHistory.getIllnesses();
    }

    public String allergies(){
        return medicalHistory.getAllergies();
    }

    public String injuries(){
        return medicalHistory.getInjuries();
    }

    public String permissions(){
        return medicalHistory.getPermissions();
    }

    public String getDOB(){
        return dob;
    }

    public Sex getSex(){
        return sex;
    }


    public int Grade(String subject){
        return rptcard.getGrade(subject);
    }

    public void changeGrade(String subject, int newMark){
        rptcard.changeGrade(subject, newMark);
    }

    public int getMark(String subject){
        return rptcard.getMark(subject);
    }

    public String getpName(){
        return parent.getName();
    }

    public String getpDOB(){
        return parent.getDOB();
    }

    public Sex getpSex(){
        return parent.getSex();
    }

    public String getpAddress(){
        return parent.Address();
    }

    public void changepAdress(String addr){
        parent.changeAddress(addr);
    }

    public String getpEmail(){
        return parent.Email();
    }

    public void changepEmail(String email){
        parent.changeEmail(email);
    }

    public String getpTel(){
        return parent.telNum();
    }

    public void changepTel(String tel){
        parent.changeTelNum(tel);
    }

    public String getpOccupation(){
        return parent.getOccupation();
    }

    public String getp2Name(){
        return parent2.getName();
    }

    public String getp2DOB(){
        return parent2.getDOB();
    }

    public Sex getp2Sex(){
        return parent2.getSex();
    }

    public String getp2Address(){
        return parent2.Address();
    }

    public void changep2Adress(String addr){
        parent2.changeAddress(addr);
    }

    public String getp2Email(){
        return parent2.Email();
    }

    public void changep2Email(String email){
        parent2.changeEmail(email);
    }

    public String getp2Tel(){
        return parent2.telNum();
    }

    public void changep2Tel(String tel){
        parent2.changeTelNum(tel);
    }

    public String getp2Occupation(){
        return parent2.getOccupation();
    }
    

    


    
    
}

   
