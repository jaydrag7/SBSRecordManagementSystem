package src.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;

import src.controller.RegisterStudentController;
import src.util.Sex;
import src.business_logic_layer.student.Student;

public class RegisterStudentUI {

    public void main(String[] args){
        try{

            if(args.length==1 && args[0].equals("parent")){

                Scanner scan = new Scanner(System.in);
                RegisterStudentController regStudentController = new RegisterStudentController();

                System.out.println("\nRegistration Page\n");

                System.out.print("Enter the name of your child/ward:");
                String name = scan.nextLine();

                System.out.print("Enter the date of birth of your child/ward (dd/mm/yyyy):");
                String dob = scan.nextLine();

                System.out.print("Enter the sex of your child/ward (M/F):");
                String sex = scan.nextLine();

                System.out.print("Enter the name of the child/ward's mother:");
                String motherName = scan.nextLine();

                System.out.print("Enter the date of birth of child/ward's mother (dd/mm/yyyy):");
                String motherDob = scan.nextLine();

                System.out.print("Enter the occupation of the child/ward's mother:");
                String motherOccupation = scan.nextLine();

                System.out.print("Enter the contact number of the child/ward's mother:");
                String motherContact = scan.nextLine();

                System.out.print("Enter the address of the child/ward's mother:");
                String motherAddress = scan.nextLine();

                System.out.print("Enter the email of the child/ward's mother:");
                String motherEmail = scan.nextLine();

                System.out.print("Enter the name of the child/ward's father:");
                String fatherName = scan.nextLine();

                System.out.print("Enter the date of birth of child/ward's father (dd/mm/yyyy):");
                String fatherDob = scan.nextLine();

                System.out.print("Enter the occupation of the child/ward's father:");
                String fatherOccupation = scan.nextLine();

                System.out.print("Enter the contact number of the child/ward's father:");
                String fatherContact = scan.nextLine();

                System.out.print("Enter the address of the child/ward's father:");
                String fatherAddress = scan.nextLine();

                System.out.print("Enter the email of the child/ward's father:");
                String fatherEmail = scan.nextLine();

                System.out.print("Enter the term the child/ward is being registered for:");
                String term = scan.nextLine();

                System.out.print("Enter the year the child/ward is being registered for:");
                String year = scan.nextLine();

                int yr = Integer.parseInt(year);

                Boolean condition1 = true;
                ArrayList<String> illnesses = new ArrayList<>();

                while (condition1){
                    System.out.print("Enter relevant illness we need to be aware of (press 'q' when done):\n");
                    String illness = scan.nextLine();

                    if(illness.equals("q") || illness.equals("Q")){
                        condition1 = false;
                    }
                    else{

                        illnesses.add(illness);

                    }
                }

                Boolean condition2 = true;
                ArrayList<String> allergies = new ArrayList<>();

                while(condition2){
                    System.out.print("Enter relevant allergy we need to be aware of (press 'q' when done):\n");
                    String allergy = scan.nextLine();

                    if(allergy.equals("q") || allergy.equals("Q")){
                        condition2 = false;
                    }
                    else{

                        allergies.add(allergy);

                    }
                }

                Boolean condition3 = true;
                HashMap<String,String> permissions = new HashMap<>();

                while(condition3){
                    System.out.print("Enter relevant permission you grant us in case of an emergency (press 'q' when done):\n");
                    String permission = scan.nextLine();

                    if(permission.equals("q") || permission.equals("Q")){
                        condition3 = false;
                    }
                    else{
    
                        permissions.put(permission,"YES");
    
                    }
                }
                
                Boolean condition4 = true;
                ArrayList<String> injuries = new ArrayList<>();

                while(condition4){
                    System.out.print("Enter relevant injury your child/ward experienced we need to be aware of (press 'q' when done):\n");
                    String injury = scan.nextLine();

                    if(injury.equals("q") || injury.equals("Q")){
                        condition4 = false;
                    }
                    else{
    
                        injuries.add("injury");
    
                    }

                }

                System.out.print("Enter the name of your child/ward's family physician:\n");
                String doctorName = scan.nextLine();

                scan.close();

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

                Sex studentSex;

                if(sex.equals("M") || sex.equals("m") ){
                    studentSex = Sex.MALE;

                    int stdID = regStudentController.assignStdID();
                    

                    Student student = new Student(stdID,name,dob,studentSex,motherName,
                    motherDob,Sex.FEMALE,motherOccupation,motherContact,motherAddress,
                    motherEmail,fatherName,fatherDob,Sex.MALE,fatherOccupation,fatherContact,
                    fatherAddress,fatherEmail,yr,term,grades,illnesses,allergies,permissions,
                    injuries,doctorName);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";

                    if(new File(excelFilePath).exists()){
                        
                        System.out.println("\n"+regStudentController.regStudent(student));
                        regStudentController.assignNursery(student);
                        regStudentController.enterStdGrds(student);
                        regStudentController.enterMedicalInfo(student);
                    }
                    else{

                        regStudentController.createExcel();
                        System.out.println("\n"+regStudentController.regStudent(student));
                        regStudentController.assignNursery(student);
                        regStudentController.enterStdGrds(student);
                        regStudentController.enterMedicalInfo(student);
                    }
                    
                }
                else if(sex.equals("F") || sex.equals("f")){
                    studentSex = Sex.FEMALE;

                    int stdID = regStudentController.assignStdID();

                    Student student = new Student(stdID,name,dob,studentSex,motherName,
                    motherDob,Sex.FEMALE,motherOccupation,motherContact,motherAddress,
                    motherEmail,fatherName,fatherDob,Sex.MALE,fatherOccupation,fatherContact,
                    fatherAddress,fatherEmail,yr,term,grades,illnesses,allergies,permissions,
                    injuries,doctorName);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";

                    if(new File(excelFilePath).exists()){
                        
                        System.out.println("\n"+regStudentController.regStudent(student));
                        regStudentController.assignNursery(student);
                        regStudentController.enterStdGrds(student);
                        regStudentController.enterMedicalInfo(student);
                    }
                    else{

                        regStudentController.createExcel();
                        System.out.println("\n"+regStudentController.regStudent(student));
                        regStudentController.assignNursery(student);
                        regStudentController.enterStdGrds(student);
                        regStudentController.enterMedicalInfo(student);
                    }

                }

            }

        }
        catch(EncryptedDocumentException ede){
            System.out.println("Encrypted document exception occured:"+ede.getMessage());
            ede.printStackTrace();

        }
        catch(IOException io){
            System.out.println("IO exception occured:"+io.getMessage());
            io.printStackTrace();

        }
    }
    
}
