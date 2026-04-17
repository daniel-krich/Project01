package com.daniel.ui;

import com.daniel.College;
import java.util.Scanner;

public class CollegeMenu implements AutoCloseable {
    
    private final Scanner scanner = new Scanner(System.in);

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
                    case 1 -> showAddLecturerMenu();
                    case 2 -> showAddCommitteeMenu();
                    case 3 -> showAddDepartmentMenu();
                    case 4 -> showAssignLecturerToACommittee();
                    case 7 -> showLecturersInformation();
                    case 8 -> showCommitteesInformation();
                    case 9 -> showMainMenu();
                    default -> menuOpt = 0;
                }
                
                if (menuOpt == 0) {
                    System.out.println("Goodbye.");
                }
                else if(menuOpt != 9){
                    System.out.print("Choose an option: ");
                }
            } catch (Exception e) { 
                System.out.println(e);
            }
        }
    }

    private void showMainMenu() {
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

    private void showAddDepartmentMenu() {
        System.out.print("Enter the name of the department you want to add (leave blank to return): ");
        String name = scanner.nextLine();
        if(!name.isBlank()) {
            if(college.addDepartment(name)) {
                System.out.println("The department '%s' was added successfully!".formatted(name));
            }
            else {
                System.out.println("The department '%s' already exists, try again!".formatted(name));
                showAddDepartmentMenu();
            }
        }
    }

    private void showAddLecturerMenu() {
        System.out.print("Enter the name of the lecturer you want to add (leave blank to return): ");
        String name = scanner.nextLine();
        if(!name.isBlank()) {
            if(college.addLecturer(name, (double)0)) {
                System.out.println("Lecturer '%s' was added successfully!".formatted(name));
            }
            else {
                System.out.println("Lecturer '%s' already exists, try again!".formatted(name));
                showAddLecturerMenu();
            }
        }
    }

    private void showAddCommitteeMenu() {
        System.out.print("Enter the name of the committee you want to add (leave blank to return): ");
        String name = scanner.nextLine();
        if(!name.isBlank()) {
            if(college.addCommittee(name)) {
                System.out.println("Committee '%s' was added successfully!".formatted(name));
            }
            else {
                System.out.println("Committee '%s' already exists, try again!".formatted(name));
                showAddCommitteeMenu();
            }
        }
    }

    private void showAssignLecturerToACommittee() {
        System.out.print("Enter lecturer name (leave blank to return): ");
        String lecturer = scanner.nextLine();
        System.out.print("Enter committee name (leave blank to return): ");
        String committee = scanner.nextLine();
        if(!lecturer.isBlank() && !committee.isBlank()) {
            if(college.assignLecturerToACommittee(lecturer, committee)) {
                System.out.println("Lecturer '%s' was assigned to committee '%s'".formatted(lecturer, committee));
            }
            else {
                System.out.println("Either '%s' is not a lecturer or the committee '%s' doesn't exists".formatted(lecturer, committee));
                showAssignLecturerToACommittee();
            }
        }
    }

    private void showLecturersInformation() {
        System.out.println("All lecturers:");
        System.out.println(college.getAllLecturers());
    }

    private void showCommitteesInformation() {
        System.out.println("All committees:");
        System.out.println(college.getAllCommittees());
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}