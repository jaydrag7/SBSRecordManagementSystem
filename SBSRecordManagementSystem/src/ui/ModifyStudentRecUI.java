package src.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;

import src.controller.ModifyStudentRecContoller;


public class ModifyStudentRecUI {
    private static Scanner scan = new Scanner(System.in);

    private static String medicalMenu(){
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
    public void main(String[] args){
        try{
            if(args.length==1 && args[0].equals("admin")){
                ModifyStudentRecContoller modStdController = new ModifyStudentRecContoller();    
    
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
    
                        System.out.println(modStdController.changeStdGrd(stdID, subject, newgrd));
    
                        System.out.print("Any more grades to modify? (Y/N):");
                        String decision = scan.nextLine();
                        if(decision.equals("N") || decision.equals("n")){
                            condition = false;
                        }
                    }    
                }
                else if(option.equals("1")){
                    //Let admin veiw pending change requests in medcial records
                }
            }
       
            else if(args.length==1 && args[0].equals("parent")){
                ModifyStudentRecContoller modStdController = new ModifyStudentRecContoller();      
                
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
                                modStdController.addNewMedicalInfo(id, "Illnesses",newIllness);

                            }

                        
                        }
                    
                    }
                    else if(option.equals("2")){
                        
                        
                        System.out.println("Please specify what your child is allergic to based on the section (leave blank to state otherwise)\n");
                        System.out.println("Use a comma for separation there are multiple\n");

                        System.out.print("\n Vaccine(s):");
                        String vaccineAllergies = scan.nextLine();
                        if(vaccineAllergies != ""){
                            modStdController.addNewMedicalInfo(id, "Allergies",vaccineAllergies);
                        }
                        

                        System.out.print("\n Food:");
                        String foodAllergies = scan.nextLine();
                        if(foodAllergies != ""){
                            modStdController.addNewMedicalInfo(id, "Allergies",foodAllergies);
                        }
                        

                        System.out.print("\n Medicaton(s):");
                        String medicationAllergies = scan.nextLine();
                        if(medicationAllergies != ""){
                            modStdController.addNewMedicalInfo(id, "Allergies",medicationAllergies);
                        }
                        

                        System.out.print("\n Others:");
                        String otherAllergies = scan.nextLine();
                        if(otherAllergies != ""){
                            modStdController.addNewMedicalInfo(id, "Allergies",otherAllergies);

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
                                modStdController.addNewMedicalInfo(id, "Permissions", newPermission);

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
                                modStdController.addNewMedicalInfo(id, "Injuries", injury);

                            }
                            
                        
                        }

                    }
                    else if(option.equals("5")){
                        System.out.println("\nPlease enter the name of child's new doctor:");
                        String newDoc = scan.nextLine();
                        System.out.println("\nNew doctor to be recorded:"+newDoc);
                        modStdController.addNewMedicalInfo(id, "Doctor", newDoc);


                    }

                    System.out.println("\n Would you like to request change for anything else? (Y/N):");
                    String requestOption = scan.nextLine();
                    if(requestOption.equals("N") || requestOption.equals("n")){
                        scan.close();
                        masterCondition = false;
                    }

                }
                




            }
        }
        catch(IOException io){
            System.out.println("IO exception occured:"+io.getMessage());
            io.printStackTrace();

        }
        catch(EncryptedDocumentException ede){
            System.out.println("Encrypted document exception occured:"+ede.getMessage());
            ede.printStackTrace();

        }
        
    }
    
}
