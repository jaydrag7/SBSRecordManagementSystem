package src.controller;
import java.util.Scanner;

public class ModifyStudentRecContoller {
    private static Scanner scan = new Scanner(System.in);
    public void modifyStudentRecord() {
        System.out.println("Please enter the student's ID:");
        String stdID = scan.nextLine();

        System.out.println("Please select the record type that you would like to modify:");
        System.out.println(ModifyStudentRecUI.adminMenu());
        System.out.print("Selected Option:");
        String option = scan.nextLine();

        if (option.equals("1")) {
            // Modify medical record
            System.out.println(ModifyStudentRecUI.medicalMenu());
            System.out.print("Selected Option:");
            String medOption = scan.nextLine();

            switch (medOption) {
                case "1":
                    // Modify illnesses
                    System.out.println("Enter new illness:");
                    String illness = scan.nextLine();
                    Student.modifyIllness(stdID, illness);
                    break;
                case "2":
                    // Modify allergies
                    System.out.println("Enter new allergy:");
                    String allergy = scan.nextLine();
                    Student.modifyAllergy(stdID, allergy);
                    break;
                case "3":
                    // Modify permissions
                    System.out.println("Enter new permission:");
                    String permission = scan.nextLine();
                    System.out.println("Enter new permission status (YES/NO):");
                    String status = scan.nextLine();
                    Student.modifyPermission(stdID, permission, status);
                    break;
                case "4":
                    // Modify injuries
                    System.out.println("Enter new injury:");
                    String injury = scan.nextLine();
                    Student.modifyInjury(stdID, injury);
                    break;
                case "5":
                    // Modify doctor
                    System.out.println("Enter new doctor:");
                    String doctor = scan.nextLine();
                    Student.modifyDoctor(stdID, doctor);
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
        } else if (option.equals("2")) {
            // Modify academic record
            System.out.println("Please enter the subject and the new grade:");
            System.out.print("Subject:");
            String subject = scan.nextLine();
            System.out.print("New Grade:");
            String newgrd = scan.nextLine();
            Student.modifyGrade(stdID, subject, newgrd);
        } else {
            System.out.println("Invalid option selected.");
        }
    }

}
