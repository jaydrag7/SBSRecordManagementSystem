package src;
import java.util.HashMap;
public class TestGrade {
    public static void main(String[] args) {
        HashMap<String, Integer> grades= new HashMap<>();
        String subject1="Math";
        String subject2="Science";
        String subject3="English";
        String subject4="Arts & Craft";

        int grd1=90;
        int grd2=80;
        int grd3=70;
        int grd4=60;
        grades.put(subject1,grd1);
        grades.put(subject2,grd2);
        grades.put(subject3,grd3);
        grades.put(subject4,grd4);
        ReportCard card = new ReportCard(2017, "Term 1", grades);
        System.out.println(card.getMark(subject4));
        System.out.println(card.getGradebook());
        card.changeGrade(subject4, 90);
        System.out.println(card.getGradebook());
        
    }
    
}
