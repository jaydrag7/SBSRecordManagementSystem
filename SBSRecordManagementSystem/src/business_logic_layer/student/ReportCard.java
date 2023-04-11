package src.business_logic_layer.student;

import java.util.HashMap;

public class ReportCard {
    private int year;
    private String term;
    private Grade gradebook;

    public ReportCard(int year, String term, HashMap<String, Integer> grades){
        this.year = year;
        this.term = term;
        this.gradebook = new Grade(grades);

    }

    public int getGrade(String subject){
        return gradebook.getGrade(subject);
    }

    public void changeGrade(String subject,int mark){
        gradebook.setGrade(subject, mark);
    }

    public int getMark(String subject){
        return gradebook.getGrade(subject);
    }

    public String getTerm(){
        return term;
    }

    public int getYear(){
        return year;
    }
}
