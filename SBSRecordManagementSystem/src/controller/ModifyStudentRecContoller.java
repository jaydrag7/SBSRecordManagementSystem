package src.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import src.persistence.ModifyStudentRecInterface;

public class ModifyStudentRecContoller implements ModifyStudentRecInterface {

    public String changeStdGrd(String studentID, String subject, String newMark) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(6);

        int lastrow= sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            String id = cell.getStringCellValue();
            if(studentID.equals(id)){
                if(subject.equals("Arts & Craft")){
                    cell = row.getCell(2);
                    cell.setCellValue((String) newMark);

                }
                else if(subject.equals(("English"))){
                    cell = row.getCell(3);
                    cell.setCellValue((String) newMark);
                }
                else if(subject.equals(("Math"))){
                    cell = row.getCell(4);
                    cell.setCellValue((String) newMark);
                }
                else if(subject.equals(("Science"))){
                    cell = row.getCell(5);
                    cell.setCellValue((String) newMark);
                }

            } 
        }



        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "Student's grade(s) have been modified";

    }

    public String addNewMedicalInfo(String studentID, String infoType, String data) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(7);

        int lastrow= sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            String id = cell.getStringCellValue();
            if(studentID.equals(id)){
                if(infoType.equals("Doctor")){
                    cell = row.getCell(2);
                    cell.setCellValue((String) data);
                }
                else if(infoType.equals("Illnesses")){
                    cell = row.getCell(3);
                    cell.setCellValue(cell.getStringCellValue()+(String) data+",");

                }
                else if(infoType.equals("Allergies")){
                    cell = row.getCell(4);
                    cell.setCellValue(cell.getStringCellValue()+(String) data+",");

                }
                else if(infoType.equals("Injuries")){
                    cell = row.getCell(5);
                    cell.setCellValue(cell.getStringCellValue()+(String) data+",");

                }
                else if(infoType.equals("Permissions")){
                    cell = row.getCell(6);
                    cell.setCellValue(cell.getStringCellValue()+(String) data+":"+"YES"+",");

                }


            }
        }


        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "New medical information has been added";
    }

    
}
    

