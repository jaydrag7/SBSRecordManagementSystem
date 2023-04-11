package src.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import src.controller.GenerateReportController;


public class GenerateReportUI {
    
    public void main(String[] args) throws IOException{
        try{

            if(args.length==1 && args[0].equals("admin")){

                GenerateReportController report = new GenerateReportController();
    
                ArrayList<String> stdGrades = new ArrayList<>();
    
                Scanner scan = new Scanner(System.in);
    
                System.out.println("Please enter Student Class/Nursery: ");
                String formClass = scan.nextLine();
    
                System.out.println("Please enter Student ID: ");
                String studentID = scan.nextLine();
    
                scan.close();
    
                stdGrades = report.getStdGrd(studentID);
    
                System.out.println("\n Class/Nursery: " + formClass + "\n");
                System.out.println("Student ID: " + stdGrades.get(0) + "\n");
                System.out.println("Student Name: " + stdGrades.get(1) + "\n");
                System.out.println("Arts: " + stdGrades.get(2) + "\n");
                System.out.println("English: " + stdGrades.get(3) + "\n");
                System.out.println("Math: " + stdGrades.get(4) + "\n");
                System.out.println("Science: " + stdGrades.get(5) + "\n");
    
                System.out.println("\n Average: " + report.stdAverage(stdGrades));
            }

        }
        catch(IOException io){
            System.out.println("IO exception occured:"+io.getMessage());
            io.printStackTrace();

        }
        

        
    }
}
