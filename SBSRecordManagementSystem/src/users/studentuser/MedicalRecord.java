package src.users.studentuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MedicalRecord {

    private int stdID;
    private String stdName;
    private ArrayList<String> illnesses = new ArrayList<>();
    private ArrayList<String> injuries = new ArrayList<>();
    private ArrayList<String> allergies = new ArrayList<>();
    private HashMap<String,String> permissions = new HashMap<>();
    private String doctorName;

    public MedicalRecord(int stdID,String stdName,ArrayList<String> illnesses,ArrayList<String> allergies,
     HashMap<String,String> permissions,ArrayList<String> injuries,
    String doctorName){
        this.stdID = stdID;
        this.stdName = stdName;
        this.illnesses = illnesses;
        this.injuries = injuries;
        this.allergies = allergies;
        this.permissions = permissions;
        this.doctorName = doctorName;
    }

    public int getstdID(){
        return stdID;
    }

    public String getStd(){
        return stdName;
    }

    public String getIllnesses(){
        String str = "";
        for(String illness: illnesses){
            str += illness + ", ";
        }      
        
        return str;
    }

    public void addIllness(String newIllness){
        illnesses.add(newIllness);
    }

    public String getAllergies(){
        String str = "";
        for(String allergy: allergies){
            str += allergy + ", ";
        }
        return str;
    }

    public void addAllergy(String allergy){
        allergies.add(allergy);
    }


    public String getPermissions(){
        String str = "";
        for(Map.Entry<String,String> permission: permissions.entrySet()){
            str += permission.getKey() + ":" + permission.getValue() + ", ";
        }
        return str;
    }

    public void addPermission(String newPermission){
        permissions.put(newPermission,"YES");
    }

    public String getInjuries(){
        String str = "";
        for(String injury: injuries){
            str += injury + ", ";
        }
        
        return str;
    }

    public void addInjury(String newInjury){
        injuries.add(newInjury);
    }

    public String getDoctor(){
        return doctorName;
    }

    public void changeDoctor(String newDoc){
        doctorName = newDoc;
    }
    
}
