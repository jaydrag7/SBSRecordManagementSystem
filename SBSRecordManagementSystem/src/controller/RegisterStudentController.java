package src.controller;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import src.business_logic_layer.student.Student;
import src.persistence.RegisterStudentInterface;
import src.util.Date;
import src.util.Sex;



public class RegisterStudentController implements RegisterStudentInterface {

    XSSFSheet sheet1;
    XSSFSheet sheet2;
    XSSFSheet sheet3;
    XSSFSheet sheet4;
    XSSFSheet sheet5;
    XSSFSheet sheet6;
    XSSFSheet sheet7;
    XSSFSheet sheet8;
    XSSFWorkbook workbook;
    private Row row;
    private Cell cell;

    private File filepath;
    private FileOutputStream stream;
    private Date date=new Date();

    public String createExcel() throws IOException{
        workbook = new XSSFWorkbook();
        sheet1 = workbook.createSheet("Students");
        sheet2 = workbook.createSheet("Nursery 1");
        sheet3 = workbook.createSheet("Nursery 2");
        sheet4 = workbook.createSheet("Nursery 3");
        sheet5 = workbook.createSheet("Nursery 4");
        sheet6 = workbook.createSheet("Nursery 5");
        sheet7 = workbook.createSheet("Student Grades");
        sheet8 = workbook.createSheet("Medical Records");

        Object data[][]={
            {"#","DATE REGISTERED","STUDENT ID","STUDENT NAME","DOB","SEX","PARENT NAME","PARENT DOB",
            "PARENT SEX","PARENT ADDRESS","PARENT EMAIL","PARENT TEL","PARENT OCCUPATION","PARENT NAME",
            "PARENT DOB","PARENT SEX","PARENT ADDRESS","PARENT EMAIL",
            "PARENT TEL","PARENT OCCUPATION"}
            
            
        };

        int rowcount1 = 0;
        for(Object d[]:data){
            row = sheet1.createRow(rowcount1++);
            int columncount = 0;
            for(Object st:d){
                cell = row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data3={
            {"NURSERY 1"},
            {"STUDENT NAME"},
        };

        int rowcount2 = 0;
        sheet2.addMergedRegion(new CellRangeAddress(0, 0,0, 3));
        sheet2.addMergedRegion(new CellRangeAddress(1, 1,0, 2));
        for(Object d[]:data3){
            row=sheet2.createRow(rowcount2++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data4={
            {"NURSERY 2"},
            {"STUDENT NAME"},
        };

        int rowcount3 = 0;
        sheet3.addMergedRegion(new CellRangeAddress(0, 0,0, 3));
        sheet3.addMergedRegion(new CellRangeAddress(1, 1,0, 2));
        for(Object d[]:data4){
            row=sheet3.createRow(rowcount3++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data5={
            {"NURSERY 3"},
            {"STUDENT NAME"},
        };

        int rowcount4 = 0;
        sheet4.addMergedRegion(new CellRangeAddress(0, 0,0, 3));
        sheet4.addMergedRegion(new CellRangeAddress(1, 1,0, 2));
        for(Object d[]:data5){
            row=sheet4.createRow(rowcount4++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data6={
            {"NURSERY 4"},
            {"STUDENT NAME"},
        };

        int rowcount5=0;
        sheet5.addMergedRegion(new CellRangeAddress(0, 0,0, 3));
        sheet5.addMergedRegion(new CellRangeAddress(1, 1,0, 2));
        for(Object d[]:data6){
            row=sheet5.createRow(rowcount5++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data7={
            {"NURSERY 5"},
            {"STUDENT NAME"},
        };

        int rowcount6=0;
        sheet6.addMergedRegion(new CellRangeAddress(0, 0,0, 3));
        sheet6.addMergedRegion(new CellRangeAddress(1, 1,0, 2));
        for(Object d[]:data7){
            row=sheet6.createRow(rowcount6++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data9={
            {"STUDENT ID","STUDENT NAME","SUBJECT GRADES"},
            {"","","Arts & Craft","English","Math","Science"}
        };

        int rowcount7=0;
        sheet7.addMergedRegion(new CellRangeAddress(0, 0,2, 5));
        for(Object d[]:data9){
            row=sheet7.createRow(rowcount7++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        Object[][] data10={
            {"STUDENT ID","STUDENT NAME","DOCTOR","RECENT ILLNESSES",
            "ALLERGIES","INJURIES","PERMISSIONS"}
            
        };

        int rowcount8=0;
       

        for(Object d[]:data10){
            row = sheet8.createRow(rowcount8++);
            int columncount = 0;
            for(Object st:d){
                cell = row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        filepath = new File("C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx");
        stream = new FileOutputStream(filepath);
        workbook.write(stream);
        stream.close();
        workbook.close();
        return "Excel File has been created successfully.";
    }

    public String regStudent(Student student) throws IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Object newdata[][]={
            {date.getTime(),student.getStdID(),student.getName(),student.getDOB(),student.getSex(),
            student.getpName(), student.getpDOB(),student.getpSex(),student.getpAddress(),
            student.getpEmail(), student.getpTel(),student.getpOccupation(),student.getp2Name(),
            student.getp2DOB(),student.getp2Sex(),student.getp2Address(),
            student.getp2Email(),student.getp2Tel(),student.getp2Occupation()
            }
        };

        int rowCount = sheet.getLastRowNum();
        for (Object[] array : newdata) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
            cell.setCellValue(rowCount);
             
            for (Object field : array) {
                cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Sex) {
                    cell.setCellValue((String) field.toString());
                }
                else if(field instanceof Integer){
                    cell.setCellValue((String) field.toString());

                }
            }

        }
        
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
      
        return "Student has been added for registration review";

    }

    public String enterStdGrds(Student student) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(6);

        Object newdata[][]={
            {student.getStdID(),student.getName(),student.getMark("Arts & Craft"),
            student.getMark("English"), student.getMark("Math"), student.getMark("Science")
            }
        };

        int rowCount = sheet.getLastRowNum();
        for (Object[] array : newdata) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
             
            for (Object field : array) {
                cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                }
                if (field instanceof Integer) {
                    cell.setCellValue((String) field.toString());
                }
            }
        }
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "Student's grade(s) have been entered";

    }

    public void assignNursery(Student student) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet1 = workbook.getSheetAt(1);
        Sheet sheet2 = workbook.getSheetAt(2);
        Sheet sheet3 = workbook.getSheetAt(3);
        Sheet sheet4 = workbook.getSheetAt(4);
        Sheet sheet5 = workbook.getSheetAt(5);

        String studentDOB = student.getDOB();
        String[] splitStudentDOB = studentDOB.split("/");
        int year_of_birth = Integer.parseInt(splitStudentDOB[2]);
        Date currentDate = new Date();
        String[] currentDateArray = currentDate.getTime().split("/|\\-|\\:");
        int currentYear = Integer.parseInt(currentDateArray[0]);

        int age = currentYear - year_of_birth;

        Object newdata[][]={
            {student.getName()}
        };

        if(age == 5){
            int rowCount = sheet5.getLastRowNum();
            for (Object[] array : newdata) {
                Row row = sheet5.createRow(++rowCount);

                int columnCount = 0;
                
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount-1);
                
                for (Object field : array) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }

        }
        else if(age == 4){
            int rowCount = sheet4.getLastRowNum();
            for (Object[] array : newdata) {
                Row row = sheet4.createRow(++rowCount);

                int columnCount = 0;
                
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount-1);
                
                for (Object field : array) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }

        }
        else if(age == 3){
            int rowCount = sheet3.getLastRowNum();
            for (Object[] array : newdata) {
                Row row = sheet3.createRow(++rowCount);

                int columnCount = 0;
                
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount-1);
                
                for (Object field : array) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }

        }
        else if(age == 2){
            int rowCount = sheet2.getLastRowNum();
            for (Object[] array : newdata) {
                Row row = sheet2.createRow(++rowCount);

                int columnCount = 0;
                
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount-1);
                
                for (Object field : array) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }

        }
        else if(age <= 1){
            int rowCount = sheet1.getLastRowNum();
            for (Object[] array : newdata) {
                Row row = sheet1.createRow(++rowCount);

                int columnCount = 0;
                
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount-1);
                
                for (Object field : array) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }

        }
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close(); 

    }

    public String enterMedicalInfo(Student student) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(7);

        Object newdata[][]={
            {student.getStdID(),student.getName(),student.getDoc(),
                student.illnesses(),student.allergies(),
                student.injuries(),student.permissions()}
        };

        int rowCount = sheet.getLastRowNum();
        for (Object[] array : newdata) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
             
            for (Object field : array) {
                cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                }
                if (field instanceof Integer) {
                    cell.setCellValue((String) field.toString());
                }
            }
        }


        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "Student medical record have been created";
    }

    public int assignStdID() throws EncryptedDocumentException, IOException{

        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        
        int id;
        int rowCount = sheet.getLastRowNum();
        Row row=sheet.getRow(rowCount);
        if (rowCount == 0){
            id = 5260000;
        }
        else{
            Cell cell=row.getCell(2);
            String ID = cell.getStringCellValue();
            id = Integer.parseInt(ID);
            id += 1;
        }
        
        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
         
        return id;

    }
    
}
