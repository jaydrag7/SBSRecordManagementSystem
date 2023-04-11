package src.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import src.persistence.GenerateReportInterface;

public class GenerateReportController implements GenerateReportInterface {

    public ArrayList<String> getStdGrd(String studentID) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(6);
        
        String stdName;
        String ArtsGrade;
        String MathGrade;
        String EnglishGrade;
        String ScienceGrade;
        ArrayList<String> Grades = new ArrayList<>();
        int lastrow= sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0); 
            String id = cell.getStringCellValue();
            if(studentID.equals(id)){
                Grades.add(studentID);
                Cell nameCell = row.getCell(1); 
                stdName = nameCell.getStringCellValue();
                Grades.add(stdName);
                Cell artsCell = row.getCell(2); 
                ArtsGrade = artsCell.getStringCellValue();
                Grades.add(ArtsGrade);
                Cell engCell = row.getCell(3); 
                EnglishGrade = engCell.getStringCellValue();
                Grades.add(EnglishGrade);
                Cell mathCell = row.getCell(4); 
                MathGrade = mathCell.getStringCellValue();
                Grades.add(MathGrade);
                Cell scienceCell = row.getCell(5); 
                ScienceGrade = scienceCell.getStringCellValue();
                Grades.add(ScienceGrade);

            } 
        }
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return Grades;
        
    }

    public Integer stdAverage(ArrayList<String> Grades){
        int gradeSum = 0;
        ArrayList<Integer> IntGrades = new ArrayList<>();
        for (int i = 2; i < Grades.size(); i++){
            IntGrades.add(Integer.parseInt(Grades.get(i)));
        }

        for (int i = 0; i < IntGrades.size(); i++){
            gradeSum += IntGrades.get(i);
        }
        int average = gradeSum/IntGrades.size();
        return average; 
    }

    
}
