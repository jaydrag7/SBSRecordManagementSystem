package src;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student("Jonmarc Young", "27/99/88", Sex.MALE, "Glenna Young", "66/99/44", Sex.FEMALE, 
        "Teacher", null, null, null, null);

        Student student2 = new Student("Jonmarc Young", "27/99/88", Sex.MALE, "Glenna Young", "66/99/44", Sex.FEMALE, 
        "Teacher", null, null, null, null);

        Student student3 = new Student("Jonmarc Young", "27/99/88", Sex.MALE, "Glenna Young", "66/99/44", Sex.FEMALE, 
        "Teacher", null, null, null, null);

        System.out.println(student2.getStdID());
        
    }
    
}
