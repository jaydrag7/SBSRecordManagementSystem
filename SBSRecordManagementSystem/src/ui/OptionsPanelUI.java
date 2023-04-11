package src.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;


public class OptionsPanelUI {

    private static String adminMenu(){
        String str;
        str= "1. Check Pending Registration"+"\n";
        str+= "2. Modify Student Record"+"\n";
        str+= "3. Remove Outdated Records"+"\n";
        str+= "4. Generate Student Report"+"\n";
        str+= "5. View Student Database"+"\n";
        str+= "6. Enter Employee Information"+"\n";
        str+= "7. View Employee Database"+"\n";
        str+= "8. Exit"+"\n";
        return str;
    }

    private static String parentMenu(){
        String str;
        str= "1. Register Student"+"\n";
        str+= "2. Medical Record Update Request"+"\n";
        return str;
    }

    public static void main(String[] args) throws IOException, EncryptedDocumentException, InterruptedException{
        if(args.length==1 && args[0].equals("admin")){

            Scanner scan = new Scanner(System.in);

            System.out.println("Welcome Admin!\n");
            System.out.println("What would you like to do today:\n");
            Boolean condition = true;
            while(condition){
                System.out.println("\n"+adminMenu());
                System.out.print("Selected Option:");
                String option =scan.nextLine();

                if(scan.hasNextLine()){
                    if(option.equals("1")){

                    }
    
                    else if(option.equals("2")){
    
                        ModifyStudentRecUI modrecUI = new ModifyStudentRecUI();
                        String[] arg = new String[1];
                        arg[0] = "admin";
                        modrecUI.main(arg);
                        //condition= false;
    
                    }
    
                    else if(option.equals("3")){
    
                        RemoveStudentRecUI removerecUI = new RemoveStudentRecUI();
                        String[] arg = new String[1];
                        arg[0] = "admin";
                        removerecUI.main(arg);
                        condition= false;
    
                    }
    
                    else if(option.equals("4")){
    
                        GenerateReportUI genReportUI = new GenerateReportUI();
                        String[] arg = new String[1];
                        arg[0] = "admin";
                        genReportUI.main(arg);
                        condition= false;
    
                    }
    
                    else if(option.equals("5")){

                        System.out.println("Please close the Excel file after viewing");
                        Thread.sleep(3000);
                        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
                        java.awt.Desktop.getDesktop().open(new File(excelFilePath));
                        condition= false;
    
                    }
    
                    else if(option.equals("6")){

                        EnterEmployeeRecUI employeeUI = new EnterEmployeeRecUI();
                        String[] arg = new String[1];
                        arg[0] = "admin";
                        employeeUI.main(arg);
                        condition= false;                      

                        
    
                    }
    
                    else if(option.equals("7")){
    
                    }
    
                    else if(option.equals("8")){
                        condition = false;
                        scan.close();
                        
                    }

                }

                

            }
        }
        else if(args.length==1 && args[0].equals("parent")){
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome Parent!\n");
            System.out.println("What would you like to do today:\n");
            Boolean condition2 = true;

            while(condition2){
                System.out.println("\n"+parentMenu());
                System.out.print("Selected Option:");

                String option =sc.nextLine();

                if(option.equals("2")){

                    ModifyStudentRecUI modrecUI = new ModifyStudentRecUI();
                    String[] arg = new String[1];
                    arg[0] = "parent";
                    modrecUI.main(arg);
                    sc.close();
                    condition2= false;
                    

                }
                else if(option.equals("1")){

                    RegisterStudentUI regStdUI = new RegisterStudentUI();
                    String[] arg = new String[1];
                    arg[0] = "parent";
                    regStdUI.main(arg);
                    sc.close();
                    condition2= false;

                }             
                
                
            }

        }
    }
    
}
