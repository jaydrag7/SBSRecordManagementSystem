package src;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ModifyStudentRecUI {
    private static Scanner scan = new Scanner(System.in);

    private static String medicalMenu(){
        String str;
        str= "1. Illnesses"+"\n";
        str+= "2. Allergies"+"\n";
        str+= "3. Medications"+"\n";
        str+= "4. Permissions"+"\n";
        str+= "5. Injuries"+"\n";
        str+= "6. Doctor"+"\n";
        return str;
    }

    private static String adminMenu(){
        String str;
        str= "1. Medical Record"+"\n";
        str+= "2. Academic Record"+"\n";
        return str;
    }
    public static void main(String[] args) throws IOException{
        if(args.length==1 && args[0].equals("admin")){

            HashMap<String, Integer> grades= new HashMap<>();
            String subject1="Math";
            String subject2="Science";
            String subject3="English";
            String subject4="Arts & Craft";

            int grd1=0;
            int grd2=0;
            int grd3=0;
            int grd4=0;
            grades.put(subject1,grd1);
            grades.put(subject2,grd2);
            grades.put(subject3,grd3);
            grades.put(subject4,grd4);

            Student student = new Student("Jonmarc Young", "15/01/2001", Sex.MALE,"Glenna Young", "30/07/1964", Sex.FEMALE, "Teacher",
            "876-999-0876", "Kingsway, Bridgeview", "glennayoung@gmail.com",
            "", "", null, "", "", "", "",2021,"Term 1", grades);

            student.createExcel();
            student.regStudent(student);
            student.enterStdGrds(student);

            System.out.println("Please select the record type that you would like to modify:");
            System.out.println(adminMenu());
            System.out.print("Selected Option:");
            String option =scan.nextLine();
            if(option.equals("2")){
                Boolean condition = true;
                while(condition){
                    System.out.println("Please enter a subject and the new grade");
                    System.out.print("Subject:");
                    String subject = scan.nextLine();

                    System.out.print("New Grade:");
                    String newgrd = scan.nextLine();


                    System.out.print("Please enter the student's ID:");
                    String stdID = scan.nextLine();


                    System.out.println("Any more grades to modify? (Y/N):");
                    String decision = scan.nextLine();
                    if(decision.equals("N")){
                        condition = false;
                        System.out.println(student.changeStdGrd(stdID, subject, newgrd));
                    }
                }
              

            }


        }
        else if(args.length==1 && args[0].equals("parent")){

            HashMap<String, Integer> grades= new HashMap<>();
            String subject1="Math";
            String subject2="Science";
            String subject3="English";
            String subject4="Arts & Craft";

            int grd1=0;
            int grd2=0;
            int grd3=0;
            int grd4=0;
            grades.put(subject1,grd1);
            grades.put(subject2,grd2);
            grades.put(subject3,grd3);
            grades.put(subject4,grd4);

            Student student = new Student("Jonmarc Young", "15/01/2001", Sex.MALE,"Glenna Young", "30/07/1964", Sex.FEMALE, "Teacher",
            "876-999-0876", "Kingsway, Bridgeview", "glennayoung@gmail.com",
            "", "", null, "", "", "", "",2021,"Term 1", grades);

            student.createExcel();

            student.regStudent(student);
            
            System.out.print("Please enter your child's ID number:");
            String id =scan.nextLine();

            System.out.println("NEW MEDICAL INFORMATION FORM\n");
            System.out.println("Use the MedicalMenu box below to select what will be modified:\n");
            System.out.print(medicalMenu()+"\n");
            System.out.print("Selected Option:");
            String option =scan.nextLine();
            int op=Integer.parseInt(option);
            if (op == 1){
                Boolean test=true;
                while(test){
                    System.out.println("Please indicate recent illness(es) experienced by your child: Press 'q' when you are finished\n");
                    String newIllness =scan.nextLine();
                    if(newIllness.equals("q")){
                        test = false;
                    }
                }
                
                



            }




        }
        
    }
    
}
