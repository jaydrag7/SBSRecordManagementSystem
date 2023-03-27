package src.users.studentuser;

import src.users.Parent;
import src.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

public class Student extends Person {

    private Parent parent;
    private Parent parent2;
    private static AtomicInteger ID=new AtomicInteger();
    private final int stdID;

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
    private ReportCard rptcard;
    private MedicalRecord medicalHistory;
    

    public Student(String name,String dob, Sex sex,String pname, String pdob, Sex psex,
    String poccupation,String pTel,String pAddr, String pEmail,String p2name,String p2dob,
    Sex p2sex, String p2_occupation,String p2Tel,String p2Addr, String p2Email,int year, 
    String term, HashMap<String, Integer> grades, ArrayList<String> illnesses,ArrayList<String> allergies,
     HashMap<String,String> permissions,ArrayList<String> injuries,
    String doctorName){

        super(name,dob,sex);
        this.parent=new Parent(pname,pdob,psex,poccupation,pTel,pEmail,pAddr);
        this.parent2=new Parent(p2name,p2dob,p2sex, p2_occupation, p2Tel,p2Email,p2Addr);
        this.rptcard = new ReportCard(year, term, grades);
        stdID = ID.getAndIncrement();
        medicalHistory = new MedicalRecord(stdID,name,illnesses, allergies, permissions, injuries, doctorName);
    }

    public String getName(){
        return name;
    }

    public String getDOB(){
        return dob;
    }

    public Sex getSex(){
        return sex;
    }

    public int getStdID(){
        return stdID;
    }

    public int Grade(String subject){
        return rptcard.getGrade(subject);
    }

    public void changeGrade(String subject, int newMark){
        rptcard.changeGrade(subject, newMark);
    }

    public int getMark(String subject){
        return rptcard.getMark(subject);
    }

    public String getpName(){
        return parent.getName();
    }

    public String getpDOB(){
        return parent.getDOB();
    }

    public Sex getpSex(){
        return parent.getSex();
    }

    public String getpAddress(){
        return parent.Address();
    }

    public void changepAdress(String addr){
        parent.changeAddress(addr);
    }

    public String getpEmail(){
        return parent.Email();
    }

    public void changepEmail(String email){
        parent.changeEmail(email);
    }

    public String getpTel(){
        return parent.telNum();
    }

    public void changepTel(String tel){
        parent.changeTelNum(tel);
    }

    public String getpOccupation(){
        return parent.getOccupation();
    }

    public String getp2Name(){
        return parent2.getName();
    }

    public String getp2DOB(){
        return parent2.getDOB();
    }

    public Sex getp2Sex(){
        return parent2.getSex();
    }

    public String getp2Address(){
        return parent2.Address();
    }

    public void changep2Adress(String addr){
        parent2.changeAddress(addr);
    }

    public String getp2Email(){
        return parent2.Email();
    }

    public void changep2Email(String email){
        parent2.changeEmail(email);
    }

    public String getp2Tel(){
        return parent2.telNum();
    }

    public void changep2Tel(String tel){
        parent2.changeTelNum(tel);
    }

    public String getp2Occupation(){
        return parent2.getOccupation();
    }
    

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
      
        return "Student has been registered";

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

    public String enterMedicalInfo(Student student) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(7);

        Object newdata[][]={
            {student.medicalHistory.getstdID(),student.medicalHistory.getStd(),student.medicalHistory.getDoctor(),
                student.medicalHistory.getIllnesses(),student.medicalHistory.getAllergies(),
                student.medicalHistory.getInjuries(),student.medicalHistory.getPermissions()}
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
