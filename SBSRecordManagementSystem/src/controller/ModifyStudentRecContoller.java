package src.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import src.users.studentuser.Student;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ModifyStudentRecContoller {

    Student student;

    public void modifyMedicalRecord(String id, String InfoType, String newValue) throws IOException{
        if (InfoType.equalsIgnoreCase("Illnesses")) {
            ArrayList<String> illnesses_ = new ArrayList<>();
            illnesses_.add(newValue);
            student.addNewMedicalInfo(id, "Illnesses", newValue);
            }
        else if (InfoType.equalsIgnoreCase("Allergies")) {
            student.addNewMedicalInfo(id, "Allergies", newValue);
            } 
        else if (InfoType.equalsIgnoreCase("Permissions")) {
            ArrayList<String> permissions_ = new ArrayList<>();
            permissions_.add(newValue);
            student.addNewMedicalInfo(id, "Permissions", newValue);
        } 
        else if (InfoType.equalsIgnoreCase("injuries_")) {
            ArrayList<String> injuries_ = new ArrayList<>();
            injuries_.add(newValue);
            student.addNewMedicalInfo(id, "Injuries", newValue);
        } 
        else if (InfoType.equalsIgnoreCase("Doctor")) {
            student.addNewMedicalInfo(id, "Doctor", newValue);
        }
    }

    public void modifyAcademicRecord(String stdID, String subject, int newGrade) throws IOException {
        
        // Check if the student exists
        if (student.getStdID() == 0) {
            System.out.println("Invalid student ID");
            return;
        }

        // Modify the grade for the specified subject
        HashMap<String, Integer> grades = this.getStdGrades().get(stdID);
        if (grades.containsKey(subject)) {
            grades.put(subject, newGrade);
        } else {
            System.out.println("Invalid subject");
            return;
        }

        // Write the modified record to the spreadsheet
        String excelFilePath = "D:\\UWI\\COMP2171\\Project\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNumber = findRowNumber(sheet, stdID);
        if (rowNumber == -1) {
            System.out.println("Error: Student ID not found");
            return;
        }
        Row row = sheet.getRow(rowNumber);

        // Update the grades for the specified subject
        int subjectColumnIndex = findColumnIndex(sheet, subject);
        Cell cell = row.getCell(subjectColumnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        cell.setCellValue(newGrade);

        // Write the changes to the spreadsheet
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        inputStream.close();
        outputStream.close();
        System.out.println("Academic record modified successfully");
    }

    private int findRowNumber(Sheet sheet, String stdID) {
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String cellValue = cell.getStringCellValue();
            if (cellValue.equals(stdID)) {
                return i;
            }
        }
        return -1;
    }

    private int findColumnIndex(Sheet sheet, String subject) {
        int lastColumnNum = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < lastColumnNum; i++) {
            Cell cell = sheet.getRow(0).getCell(i);
            String cellValue = cell.getStringCellValue();
            if (cellValue.equals(subject)) {
                return i;
            }
        }
        return -1;
    }

    public HashMap<String, HashMap<String, Integer>> getStdGrades() throws IOException {
        HashMap<String, HashMap<String, Integer>> stdGrades = new HashMap<>();
    
        String excelFilePath = "D:\\UWI\\COMP2171\\Project\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
    
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
    
            // Get the student ID and create a new HashMap to store the grades for this student
            String stdID = row.getCell(0).getStringCellValue();
            HashMap<String, Integer> grades = new HashMap<>();
    
            for (int j = 2; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String subject = sheet.getRow(0).getCell(j).getStringCellValue();
                int grade = (int) cell.getNumericCellValue();
                grades.put(subject, grade);
            }
    
            // Add the grades HashMap to the stdGrades HashMap
            stdGrades.put(stdID, grades);
        }
    
        workbook.close();
        inputStream.close();
    
        return stdGrades;
    }

}
