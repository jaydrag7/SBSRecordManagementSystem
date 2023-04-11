package src.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import src.business_logic_layer.Employee;
import src.controller.EnterEmployeeRecController;
import src.util.EType;
import src.util.Sex;

public class EnterEmployeeRecUI {

    private String employeeMenu(){
        String str;
        str = "1. Admin\n";
        str += "2. General Staff\n";
        return str;
    }

    public void main(String[] args){
        if(args.length==1 && args[0].equals("admin")){
            try{

                Scanner scan = new Scanner(System.in);
                EnterEmployeeRecController employeeController = new EnterEmployeeRecController();
                Employee employee;

                System.out.print("Enter employee's name:");
                String employeeName = scan.nextLine();

                System.out.print("Enter employee's date of birth:");
                String employeeDOB = scan.nextLine();

                System.out.print("Enter employee's sex (M/F):");
                String employeeSex = scan.nextLine();

                System.out.print("Enter employee's address:");
                String employeeAddress = scan.nextLine();

                System.out.print("Enter employee's email:");
                String employeeEmail = scan.nextLine();

                System.out.print("Enter employee's telephone number:");
                String employeeTelNum = scan.nextLine();

                System.out.println("Select employee's role:");
                System.out.println(employeeMenu());
                System.out.print("Selected Option:");
                String employeeType = scan.nextLine();

                scan.close();

                if(employeeType.equals("1") && (employeeSex.equals("M") || employeeSex.equals("m"))){

                    employee = new Employee(employeeName, employeeDOB, Sex.MALE, EType.ADMIN,
                    employeeTelNum, employeeEmail, employeeAddress);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
                    if(new File(excelFilePath).exists()){

                        System.out.println("\n"+employeeController.enterGEmployee(employee));
                        
                    }
                    else{

                        employeeController.createExcel();
                        System.out.println("\n"+employeeController.enterGEmployee(employee));

                    }


                }
                else if(employeeType.equals("1") && (employeeSex.equals("F") || employeeSex.equals("f"))){

                    employee = new Employee(employeeName, employeeDOB, Sex.FEMALE, EType.ADMIN,
                    employeeTelNum, employeeEmail, employeeAddress);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
                    if(new File(excelFilePath).exists()){

                        System.out.println("\n"+employeeController.enterGEmployee(employee));
                        
                    }
                    else{

                        employeeController.createExcel();
                        System.out.println("\n"+employeeController.enterGEmployee(employee));

                    }


                }
                else if(employeeType.equals("2") && (employeeSex.equals("M") || employeeSex.equals("m"))){

                    employee = new Employee(employeeName, employeeDOB, Sex.MALE, EType.GENERAL,
                    employeeTelNum, employeeEmail, employeeAddress);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
                    if(new File(excelFilePath).exists()){

                        System.out.println("\n"+employeeController.enterGEmployee(employee));
                        
                    }
                    else{

                        employeeController.createExcel();
                        System.out.println("\n"+employeeController.enterGEmployee(employee));

                    }



                }
                else if(employeeType.equals("2") && (employeeSex.equals("F") || employeeSex.equals("f"))){

                    employee = new Employee(employeeName, employeeDOB, Sex.FEMALE, EType.GENERAL,
                    employeeTelNum, employeeEmail, employeeAddress);

                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
                    if(new File(excelFilePath).exists()){

                        System.out.println("\n"+employeeController.enterGEmployee(employee));
                        
                    }
                    else{

                        employeeController.createExcel();
                        System.out.println("\n"+employeeController.enterGEmployee(employee));

                    }

                }              
            }
            catch(IOException io){
                System.out.println("IO exception occured:"+io.getMessage());
                io.printStackTrace();
    
            }
        }        
    }  
}
