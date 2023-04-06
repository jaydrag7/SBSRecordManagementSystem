package src.ui;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import src.users.studentuser.Student;
import src.controller.ModifyStudentRecController;
import src.util.Sex;

public class ModifyStudentRecUI {
    private static Scanner scan = new Scanner(System.in);

    public static String medicalMenu(){
        String str;
        str= "1. Illnesses"+"\n";
        str+= "2. Allergies"+"\n";
        str+= "3. Permissions"+"\n";
        str+= "4. Injuries"+"\n";
        str+= "5. Doctor"+"\n";
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

            ArrayList<String> illnesses = new ArrayList<>();
            illnesses.add("Chicken Pox");
            illnesses.add("Asthma");
            illnesses.add("Eye Trouble");

            ArrayList<String> allergies = new ArrayList<>();
            allergies.add("Citrus");


            HashMap<String,String> permissions = new HashMap<>();
            permissions.put("Panadol","YES");
            permissions.put("Emergency Care- First Aid","YES");

            ArrayList<String> injuries = new ArrayList<>();
            injuries.add("");

            String dName = "Dr. Steve Wosniack";



            Student student = new Student("Chris Doug", "15/01/2019", Sex.MALE,"Mary Doug",
             "30/07/1964", Sex.FEMALE, "Teacher","876-999-0876", "Kingsway, Bridgeview",
             "doug@gmail.com","Francis Doug", "06/04/1955", Sex.MALE, "Mechanic", "876-339-7854", "Kingsway, Bridgeview",
             "francisdoug@gmail.com",2021,"Term 1",grades,illnesses,allergies,permissions,injuries,dName);

            student.createExcel();
            student.regStudent(student);
            student.enterStdGrds(student);
            student.enterMedicalInfo(student);

            HashMap<String, Integer> grades2= new HashMap<>();
            String subject_1="Math";
            String subject_2="Science";
            String subject_3="English";
            String subject_4="Arts & Craft";

            int grd_1=0;
            int grd_2=0;
            int grd_3=0;
            int grd_4=0;
            grades2.put(subject_1,grd_1);
            grades2.put(subject_2,grd_2);
            grades2.put(subject_3,grd_3);
            grades2.put(subject_4,grd_4);

            ArrayList<String> illnesses2 = new ArrayList<>();
            illnesses2.add("Hay Fever");
            illnesses2.add("Kidney Trouble");
            illnesses2.add("Whooping Cough");

            ArrayList<String> allergies2 = new ArrayList<>();
            allergies2.add("Dairy");

            HashMap<String,String> permissions2 = new HashMap<>();
            permissions2.put("Panadol","YES");
            permissions2.put("Emergency Care- First Aid","YES");

            ArrayList<String> injuries2 = new ArrayList<>();
            injuries2.add("");

            String dName2 = "Dr. Margaret Hamilton";

            Student student2 = new Student("Stacy Morgan", "09/11/2020", Sex.FEMALE,"Jean Morgan",
             "27/09/1990", Sex.FEMALE, "Accountant","876-923-8894", "Swim Lane, Little London",
             "morgan@gmail.com","Jermaine Morgan", "09/03/2000", Sex.MALE, "Athlete",
             "876-947-9863", "Swim Lane, Little London", "jermainemorgan@gmail.com",2021,"Term 1",
             grades2,illnesses2,allergies2,permissions2,injuries2,dName2);

             String excelFilePath = "D:\\UWI\\COMP2171\\Project\\Student Information.xlsx";
             if(new File(excelFilePath).exists()){
                student2.regStudent(student2);
                student2.enterStdGrds(student2);
                student2.enterMedicalInfo(student2);}


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

                    ModifyStudentRecController data = new ModifyStudentRecController();
                    data.modifyAcademicRecord(stdID, subject, newgrd);

                    System.out.println("Any more grades to modify? (Y/N):");
                    String decision = scan.nextLine();
                    if(decision.equals("N")){
                        condition = false;
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

            ArrayList<String> illnesses = new ArrayList<>();
            illnesses.add("Chicken Pox");
            illnesses.add("Asthma");
            illnesses.add("Eye Trouble");

            ArrayList<String> allergies = new ArrayList<>();
            allergies.add("Citrus");


            HashMap<String,String> permissions = new HashMap<>();
            permissions.put("Panadol","YES");
            permissions.put("Emergency Care- First Aid","YES");

            ArrayList<String> injuries = new ArrayList<>();
            injuries.add("");

            String dName = "Dr. Steve Wosniack";



            Student student = new Student("Didly Doug", "15/01/2019", Sex.MALE,"Mary Doug",
             "30/07/1964", Sex.FEMALE, "Teacher","876-999-0876", "Kingsway, Bridgeview",
             "doug@gmail.com","", "Francis Doug", Sex.MALE, "Mechanic", "876-339-7854", "Kingsway, Bridgeview",
             "francisdoug@gmail.com",2021,"Term 1",grades,illnesses,allergies,permissions,injuries,dName);


            student.createExcel();
            student.regStudent(student);
            student.enterStdGrds(student);
            student.enterMedicalInfo(student);

            System.out.print("Please enter your child's ID number:");
            String id =scan.nextLine();

            System.out.println("NEW MEDICAL INFORMATION FORM\n");
            Boolean masterCondition = true;
            while(masterCondition){
                System.out.println("Use the Medical Menu box below to select what will be modified:\n");
                System.out.print(medicalMenu()+"\n");
                System.out.print("Selected Option:");
                String option =scan.nextLine();

                if (option.equals("1")){
                    Boolean condition = true;
                    ArrayList<String> illnesses_ = new ArrayList<>();
                    while(condition){
                        System.out.println("\nPlease indicate recent illness(es) experienced by your child (press 'q' when done):\n");
                        String newIllness =scan.nextLine();

                        if(newIllness.equals("q")){
                            condition = false;
                            System.out.println("New illness(es) to be recorded:\n");
                            for(int i = 0; i<illnesses_.size();i++){
                                System.out.println(illnesses_.get(i)+"\n");
                            }
                        }
                        else{

                            illnesses_.add(newIllness);
                            student.addNewMedicalInfo(id, "Illnesses",newIllness);

                        }


                    }

                }
                else if(option.equals("2")){


                    System.out.println("Please specify what your child is allergic to based on the section (leave blank to state otherwise)\n");
                    System.out.println("Use a comma for separation there are multiple\n");

                    System.out.print("\n Vaccine(s):");
                    String vaccineAllergies = scan.nextLine();
                    if(vaccineAllergies != ""){
                        student.addNewMedicalInfo(id, "Allergies",vaccineAllergies);
                    }


                    System.out.print("\n Food:");
                    String foodAllergies = scan.nextLine();
                    if(foodAllergies != ""){
                        student.addNewMedicalInfo(id, "Allergies",foodAllergies);
                    }


                    System.out.print("\n Medicaton(s):");
                    String medicationAllergies = scan.nextLine();
                    if(medicationAllergies != ""){
                        student.addNewMedicalInfo(id, "Allergies",medicationAllergies);
                    }


                    System.out.print("\n Others:");
                    String otherAllergies = scan.nextLine();
                    if(otherAllergies != ""){
                        student.addNewMedicalInfo(id, "Allergies",otherAllergies);

                    }


                    System.out.println("New allergies to be recorded\n");

                    System.out.print("\n Vaccine(s):");
                    System.out.print("\n" + vaccineAllergies);

                    System.out.print("\n Food:");
                    System.out.print("\n" + foodAllergies);

                    System.out.print("\n Medication(s):");
                    System.out.print("\n" + medicationAllergies);

                    System.out.print("\n Others:");
                    System.out.print("\n" + otherAllergies);
                }
                else if(option.equals("3")){
                    Boolean condition = true;
                    ArrayList<String> permissions_ = new ArrayList<>();
                    while(condition){
                        System.out.print("\nPlease enter new permission you wish to grant (press 'q' when done):");
                        String newPermission = scan.nextLine();
                        if(newPermission.equals("q")){
                            condition = false;
                            System.out.println("\nNew Permissions to be recorded:");
                            for(int i = 0; i<permissions_.size();i++){
                                System.out.println("\n"+permissions_.get(i));
                            }
                        }
                        else{

                            permissions_.add(newPermission);
                            student.addNewMedicalInfo(id, "Permissions", newPermission);

                        }

                    }


                }
                else if(option.equals("4")){
                    Boolean condition = true;
                    ArrayList<String> injuries_ = new ArrayList<>();
                    while(condition){
                        System.out.print("\nPlease enter any significant injuries your child has recently experienced (press 'q' when done):");
                        String injury = scan.nextLine();
                        if(injury.equals("q")){
                            condition = false;
                            System.out.println("\nNew injuries to be recorded:");
                            for(int i = 0; i<injuries_.size();i++){
                                System.out.println("\n"+injuries_.get(i));
                            }

                        }
                        else{

                            injuries_.add(injury);
                            student.addNewMedicalInfo(id, "Injuries", injury);

                        }


                    }

                }
                else if(option.equals("5")){
                    System.out.println("\nPlease enter the name of child's new doctor:");
                    String newDoc = scan.nextLine();
                    System.out.println("\nNew doctor to be recorded:"+newDoc);
                    student.addNewMedicalInfo(id, "Doctor", newDoc);


                }

                System.out.println("\n Would you like to request change for anything else? (Y/N)");
                String requestOption = scan.nextLine();
                if(requestOption.equals("N")){
                    masterCondition = false;
                }

            }





        }

    }

}
