package src.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.Console;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class OptionsPanelUI {

    private static String adminMenu(){
        String str;
        str= "1. Modify Student Record"+"\n";
        str+= "2. Remove Outdated Records"+"\n";
        str+= "3. Generate Student Report"+"\n";
        str+= "4. View Student Database"+"\n";
        str+= "5. Enter Employee Information"+"\n";
        str+= "6. View Employee Database"+"\n";
        str+= "7. Exit"+"\n";
        return str;
    }

    private static String parentMenu(){
        String str;
        str= "1. Register Student"+"\n";
        str+= "2. Medical Record Update Request"+"\n";
        return str;
    }

    private static String loginMenu(){
        String str;
        str = "1. Login\n";
        str += "2. Create Account\n";
        return str;
    }

    private static void writeUserData(String adminName, String adminPassword) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Users.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Object newdata[][]={
            {adminName,adminPassword}
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
                }
            }
        }
        inputStream.close(); 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

    private static void createUserExcel() throws IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Admin");

        Object[][] data={
            {"#","NAME","PASSWORD"}
        };

        int rowcount=0;
        for(Object d[]:data){
            XSSFRow row = sheet.createRow(rowcount++);
            int columncount=0;
            for(Object st:d){
                XSSFCell cell = row.createCell(columncount++);
                if(st instanceof String)
                    cell.setCellValue((String) st);

            }
        }
        File filepath = new File("C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Users.xlsx");
        FileOutputStream stream = new FileOutputStream(filepath);
        workbook.write(stream);
        stream.close();
        workbook.close();
    }

    private static String authenticateUser(String adminName, String adminPassword) throws EncryptedDocumentException, IOException{
        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Users.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        String message;

        int lastrow= sheet.getLastRowNum();
        for(int i=1;i<=lastrow;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(1);
            Cell cell2=row.getCell(2);

            String name = cell.getStringCellValue();
            String password = cell2.getStringCellValue();

            if(name.equals(adminName) && password.equals(adminPassword)){
                message = "verified";
                inputStream.close(); 
                FileOutputStream outputStream = new FileOutputStream( excelFilePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                return message;
            }

        }
        message = "not verified";
        inputStream.close(); 
        FileOutputStream outputStream = new FileOutputStream( excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return message;

    }

    public static void main(String[] args) throws IOException, EncryptedDocumentException, InterruptedException{
        if(args.length==1 && args[0].equals("admin")){

            Scanner scan = new Scanner(System.in);
            Console console= System.console();

            System.out.println(loginMenu());
            System.out.print("Selected Option:");
            String opt = scan.nextLine();

            if(opt.equals("1")){
                Boolean authenticator = true;
                while(authenticator){

                    System.out.print("\n Admin Name:");
                    String adminName = scan.nextLine();
                    
                    char[] passwordArray = console.readPassword("\n Password: ");
                    String adminPassword = new String(passwordArray);                  
                    
                    String msg = authenticateUser(adminName, adminPassword);
                    if(msg.equals("verified")){
                        authenticator = false;
                    }
                    else if(msg.equals("not verified")){
                        authenticator = true;
                    }
                }
                

            }
            else if(opt.equals("2")){
                System.out.print("\n Admin Name:");
                String adminName = scan.nextLine();
                
                char[] passwordArray = console.readPassword("\n Password: ");
                String adminPassword = new String(passwordArray);

                String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Users.xlsx";
                if(new File(excelFilePath).exists()){
                    writeUserData(adminName, adminPassword);
                }
                else{
                    createUserExcel();
                    writeUserData(adminName, adminPassword);
                }

            }            

            System.out.println("\n Welcome Admin!\n");
            System.out.println("What would you like to do today:\n");

            Boolean condition = true;
            while(condition){
                System.out.println("\n"+adminMenu());
                System.out.print("Selected Option:");
                String option =scan.nextLine();

                
                if(option.equals("1")){

                    ModifyStudentRecUI modrecUI = new ModifyStudentRecUI();
                    String[] arg = new String[1];
                    arg[0] = "admin";
                    modrecUI.main(arg);
                    condition = true;

                }

                else if(option.equals("2")){

                    RemoveStudentRecUI removerecUI = new RemoveStudentRecUI();
                    String[] arg = new String[1];
                    arg[0] = "admin";
                    removerecUI.main(arg);
                    condition = true;                    

                }

                else if(option.equals("3")){

                    GenerateReportUI genReportUI = new GenerateReportUI();
                    String[] arg = new String[1];
                    arg[0] = "admin";
                    genReportUI.main(arg);
                    condition = false;                    

                }

                else if(option.equals("4")){

                    System.out.println("Please close the Excel file after viewing");
                    Thread.sleep(2000);
                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
                    java.awt.Desktop.getDesktop().open(new File(excelFilePath));
                    condition = true;                    

                }

                else if(option.equals("5")){

                    EnterEmployeeRecUI employeeUI = new EnterEmployeeRecUI();
                    String[] arg = new String[1];
                    arg[0] = "admin";
                    employeeUI.main(arg);
                    condition = false;
                    
                }

                else if(option.equals("6")){

                    
                    System.out.println("Please close the Excel file after viewing");
                    Thread.sleep(2000);
                    String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Employee Information.xlsx";
                    java.awt.Desktop.getDesktop().open(new File(excelFilePath));
                    condition = true;
                }

                else if(option.equals("7")){

                    scan.close();                        
                    condition= false; 
                }
            }
        }
        else if(args.length==1 && args[0].equals("parent")){
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome Parent!\n");
            System.out.println("What would you like to do today:\n");
            Boolean condition2 = true;

            while(condition2){
                System.out.println("\n"+parentMenu());
                System.out.print("Selected Option:");

                String option =sc.nextLine();

                if(option.equals("2")){

                    ModifyStudentRecUI modrecUI = new ModifyStudentRecUI();
                    String[] arg = new String[1];
                    arg[0] = "parent";
                    modrecUI.main(arg);
                    sc.close();    
                    condition2= false;
                }
                else if(option.equals("1")){

                    RegisterStudentUI regStdUI = new RegisterStudentUI();
                    String[] arg = new String[1];
                    arg[0] = "parent";
                    regStdUI.main(arg);  
                    sc.close();                  
                    condition2= false;
                }   
                
                
            }

        }
    }
    
}
