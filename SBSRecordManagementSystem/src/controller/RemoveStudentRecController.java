package src.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import src.util.Date;

public class RemoveStudentRecController {

    public String removeRecords() throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet6 = workbook.getSheetAt(6);
        Sheet sheet7 = workbook.getSheetAt(7);

        int lastrow = sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row = sheet.getRow(i);
            Row row6 = sheet6.getRow(i+1);
            Row row7 = sheet7.getRow(i);

            Cell cell = row.getCell(1);

            String[] fdate= cell.getStringCellValue().split("/|\\-|\\:");
            int firstDate=Integer.parseInt(fdate[4]);
            Date ndate =new Date();
            String[] ndate_lst=ndate.getTime().split("/|\\-|\\:");
            int newDate=Integer.parseInt(ndate_lst[4]);
            if(Math.abs(newDate-firstDate) >= 2){
                sheet.removeRow(row);
                sheet6.removeRow(row6);
                sheet7.removeRow(row7);
            }
        }
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "Student(s) has been removed";
    }

    public String sendAlert() throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        String st = "";
        int lastrow = sheet.getLastRowNum();
        int i;
        for(i=1;i<=lastrow;i++){
            Row row = sheet.getRow(i);

            Cell cell = row.getCell(1);

            String[] fdate= cell.getStringCellValue().split("/|\\-|\\:");
            int firstDate=Integer.parseInt(fdate[4]);
            Date ndate =new Date();
            String[] ndate_lst=ndate.getTime().split("/|\\-|\\:");
            int newDate=Integer.parseInt(ndate_lst[4]);
            if(Math.abs(newDate-firstDate) >= 2){
                CellStyle cellStyle = cell.getSheet().getWorkbook().createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);
                st = "!! Old Data Found !!";
            }
        }
        if (st == ""){
            st = "!! No Old Data Found !!";
        }

        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return st;
    }
    
}
