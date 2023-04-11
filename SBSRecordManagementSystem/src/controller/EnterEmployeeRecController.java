package src.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.business_logic_layer.Employee;
import src.util.EType;
import src.util.Sex;

public class EnterEmployeeRecController {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Row row;
    private Cell cell;
    private File filepath;
    private FileOutputStream stream;

    public void createExcel() throws IOException{
        workbook=new XSSFWorkbook();
        sheet = workbook.createSheet("Employees");

        Object[][] data={
            {"#","EMPLOYEE NAME","EMPLOYEE DOB","EMPLOYEE SEX","EMPLOYEE ADDRESS",
            "EMPLOYEE EMAIL","EMPLOYEE TEL","EMPLOYEE TYPE"}
        };

        int rowcount=0;
        for(Object d[]:data){
            row=sheet.createRow(rowcount++);
            int columncount=0;
            for(Object st:d){
                cell=row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }

        filepath = new File("C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx");
        stream = new FileOutputStream(filepath);
        workbook.write(stream);
        stream.close();
        workbook.close();

    }

    public String enterGEmployee(Employee employee) throws EncryptedDocumentException, IOException{

        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Object newdata[][]={
            {employee.getName(),employee.getDOB(),employee.getSex(),employee.Address(),
            employee.Email(),employee.telNum(),employee.getEType()}
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
                }else if(field instanceof EType){
                    cell.setCellValue((String) field.toString());

                }
            }

        }

        inputStream.close();
 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return "Employee Data has been entered";

    }
    
}
