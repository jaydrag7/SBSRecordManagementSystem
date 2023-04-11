package src.business_logic_layer.student;
import java.util.*;
public class Grade{

    private  HashMap<String, Integer> grades= new HashMap<>();


    public Grade(HashMap<String, Integer> grades){
        this.grades=grades; 
    }


    public int getGrade(String subject){
        return this.grades.get(subject);
    }

    public void setGrade(String subject,int mark){
        this.grades.replace(subject,mark);
    }

    public HashMap<String, Integer> getGrades(){
        return grades;
    }

}