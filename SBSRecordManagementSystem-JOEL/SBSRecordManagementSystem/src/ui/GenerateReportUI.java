package src.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import src.controller.GenerateReportController;

public class GenerateReportUI {
    
    public static void main(String[] args) throws IOException{
        GenerateReportController report = new GenerateReportController();
        ArrayList<String> stdGrades = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Student Class/Nursery: ");
        String formClass = scan.nextLine();
        System.out.println("Please enter Student ID: ");
        String studentID = scan.nextLine();
        stdGrades = report.getStdGrd(studentID);
        System.out.println("Class/Nursery: " + formClass);
        System.out.println("Student ID: " + stdGrades.get(0));
        System.out.println("Student Name: " + stdGrades.get(1));
        System.out.println("Arts: " + stdGrades.get(2));
        System.out.println("English: " + stdGrades.get(3));
        System.out.println("Math: " + stdGrades.get(4));
        System.out.println("Science: " + stdGrades.get(5));
        System.out.println("Average: " + report.stdAverage(stdGrades));
    }
}
