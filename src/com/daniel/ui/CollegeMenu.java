package com.daniel.ui;

import com.daniel.College;
import java.util.Scanner;

public class CollegeMenu implements AutoCloseable {
    
    public Scanner scanner = new Scanner(System.in);

    private final College college;

    public CollegeMenu(College _college) {
        college = _college;
    }

    public void runMenu() {
        while(college.getCollegeName().isBlank()) {
            try {
                System.out.print("Enter college name: ");
                college.setCollengeName(scanner.nextLine());
            } catch (Exception e) { }
        }

        showMainMenu();

        int menuOpt = -1;
        while(menuOpt != 0) {
            try {
                menuOpt = scanner.nextInt();
                scanner.nextLine(); 
                
                switch(menuOpt) {
                    case 3 -> showAddDepartmentMenu();
                    case 9 -> showMainMenu();
                    default -> menuOpt = 0;
                }
                
                if (menuOpt == 0) {
                    System.out.println("Goodbye.");
                }
                else if(menuOpt != 9){
                    System.out.print("Choose an option: ");
                }
            } catch (Exception e) { }
        }
    }

    public void showMainMenu() {
        System.out.println("\n=== Management Menu - " + college.getCollegeName() + " ===");
        System.out.println("0 - Exit");
        System.out.println("1 - Add a lecturer");
        System.out.println("2 - Add a committee");
        System.out.println("3 - Add a study department");
        System.out.println("4 - Assign a lecturer to a committee");
        System.out.println("5 - Show average salary of all lecturers in the college");
        System.out.println("6 - Show average salary of all lecturers in a specific department");
        System.out.println("7 - Show details of all lecturers");
        System.out.println("8 - Show details of all committees");
        System.out.println("9 - Show menu again");
        System.out.print("Choose an option: ");
    }

    public void showAddDepartmentMenu() {
        System.out.print("Enter the name of the department you want to add (leave blank to return): ");
        String name = scanner.nextLine();
        if(!name.isBlank()) {
            if(college.addDepartment(name)) {
                System.out.println("The department was added successfully!");
            }
            else {
                System.out.println("The department already exists, try again!");
                showAddDepartmentMenu();
            }
        }
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}