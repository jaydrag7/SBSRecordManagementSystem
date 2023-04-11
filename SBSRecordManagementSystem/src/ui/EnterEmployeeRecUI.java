package src.ui;

import java.io.IOException;

import src.business_logic_layer.Employee;
import src.controller.EnterEmployeeRecController;
import src.util.EType;
import src.util.Sex;

public class EnterEmployeeRecUI {

    public void main(String[] args){
        if(args.length==1 && args[0].equals("admin")){
            try{

                EnterEmployeeRecController employeeController = new EnterEmployeeRecController();
                employeeController.createExcel();

                Employee employee = new Employee(0, "Jonmarc Young", "09/09/2001", Sex.MALE, EType.ADMIN,
                "876-983-0972", "jonmarc@gmail.com", "Portmore, St. Catherine");

                System.out.println(employeeController.enterGEmployee(employee));
    
            }
            catch(IOException io){
                System.out.println("IO exception occured:"+io.getMessage());
                io.printStackTrace();
    
            }

        }        

    }
    
}
