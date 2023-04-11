package src.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import org.apache.poi.EncryptedDocumentException;

import src.controller.RemoveStudentRecController;

public class RemoveStudentRecUI {
    public void main(String[] args){
        try{
            if(args.length==1 && args[0].equals("admin")){
                Scanner scan = new Scanner(System.in);
                //Sends alert indicating students can be removed from the database.
                RemoveStudentRecController record = new RemoveStudentRecController();                

                String alert = record.sendAlert();
                System.out.println(alert);
                if (alert.equals("!! Old Data Found !!")){
                    //Let admin view data first
                    System.out.print("Please press 'v' to view the data before removing:");
                    String response = scan.nextLine();
                    
    
                    if (response.equals("v") || response.equals("V")){
                        System.out.println("Please ensure to close the Excel file after viewing.");
                        Thread.sleep(3000);
                        String excelFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\OneDrive\\Desktop\\Student Information.xlsx";
                        java.awt.Desktop.getDesktop().open(new File(excelFilePath));
    
                        System.out.print("Would you like to proceed in removing the records (Y/N):");
                        String response2 = scan.nextLine();
                        scan.close();
                        if(response2.equals("Y")){
                            System.out.print(record.removeRecords());
                        }
                        else if(response2.equals("N")){
                            System.out.println("No student has been removed");
                        }
                        
                    }
                    
                    
                }
                
            }
            
        }
        catch(EncryptedDocumentException ede){
            System.out.println("Encrypted document exception occured:"+ede.getMessage());
            ede.printStackTrace();

        }
        catch(IOException io){
            System.out.println("IO exception occured:"+io.getMessage());
            io.printStackTrace();

        }
        catch(InterruptedException ie){
            System.out.println("Interrupted exception occured:"+ie.getMessage());
            ie.printStackTrace();

        }
        
    }
}
