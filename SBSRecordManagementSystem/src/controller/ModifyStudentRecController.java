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

public class ModifyStudentRecController {

    Student student = new Student(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null);

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

    public void modifyAcademicRecord(String stdID, String subject, String newGrade) throws IOException {
        
        // Check if the student exists
        if (student.getStdID() == 0) {
            System.out.println("Invalid student ID");
            return;
        }

        // Write the modified record to the spreadsheet
        String excelFilePath = "D:\\UWI\\COMP2171\\Project\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(6);

        int lastrow= sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            String id = cell.getStringCellValue();
            if(stdID.equals(id)){
                if(subject.equals("Arts & Craft")){
                    cell = row.getCell(2);
                    cell.setCellValue((String) newGrade);

                }
                else if(subject.equals(("English"))){
                    cell = row.getCell(3);
                    cell.setCellValue((String) newGrade);
                }
                else if(subject.equals(("Math"))){
                    cell = row.getCell(4);
                    cell.setCellValue((String) newGrade);
                }
                else if(subject.equals(("Science"))){
                    cell = row.getCell(5);
                    cell.setCellValue((String) newGrade);
                }

            } 
    
        }

        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Record has been modified");

    }
}
