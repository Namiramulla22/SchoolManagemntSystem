package com.School;

import com.School.Service.ClassService;
import com.School.ServiceImp.ClassServiceImp;
import com.School.entities.Class;
import com.School.DaoImp.ClassDaoimp;

import java.util.List;
import java.util.Scanner;

public class ClassOperation {

    // Initialize the ClassService with the DAO implementation
    private static final ClassService classService = new ClassServiceImp(new ClassDaoimp());
    private static final Scanner scanner = new Scanner(System.in);

    public static void classOperations() {
        while (true) {
            System.out.println("Press 1. Add Class");
            System.out.println("Press 2. View All Classes");
            System.out.println("Press 3. Update Class");
            System.out.println("Press 4. Delete Class");
            System.out.println("Press 5. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addClass();
                    break;
                case 2:
                    viewAllClasses();
                    break;
                case 3:
                    updateClass();
                    break;
                case 4:
                    deleteClass();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Class
    private static void addClass() {
        
    	System.out.println("Enter a class ID");
        Long classId=scanner.nextLong();
    	
    	System.out.println("Enter Class Name: ");
        String name = scanner.next();

        System.out.println("Enter Section: ");
        String section = scanner.next();
        
        

        // Here you would probably select the teacher to associate with the class
        // but for simplicity, let's assume the teacher is not being assigned here.

        Class classes = new Class();
        classes.setClassId(classId);
        classes.setName(name);
        classes.setSection(section);

        // Call the service to create the class
        Class createdClass = classService.createClass(classes);
        if (createdClass != null) {
            System.out.println("Class added successfully: " + createdClass);
        } else {
            System.out.println("Failed to add class.");
        }
    }

    // View all Classes
    private static void viewAllClasses() {
        List<Class> classes = classService.getAllClasses();
        if (classes != null && !classes.isEmpty()) {
            for (Class studentClass : classes) {
                System.out.println(studentClass);
            }
        } else {
            System.out.println("No classes found.");
        }
    }

    // Update an existing Class
    private static void updateClass() {
        System.out.println("Enter Class ID to update: ");
        Long classId = scanner.nextLong();

        // Retrieve the class to update
        Class classToUpdate = classService.getClassById(classId);
        if (classToUpdate == null) {
            System.out.println("Class not found.");
            return;
        }

        System.out.println("Enter new Class Name: ");
        String newName = scanner.next();

        System.out.println("Enter new Section: ");
        String newSection = scanner.next();

        // Update the class details
        classToUpdate.setName(newName);
        classToUpdate.setSection(newSection);

        Class updatedClass = classService.updateClass(classId, classToUpdate);
        if (updatedClass != null) {
            System.out.println("Class updated successfully: " + updatedClass);
        } else {
            System.out.println("Failed to update class.");
        }
    }

    // Delete a Class
    private static void deleteClass() {
        System.out.println("Enter Class ID to delete: ");
        Long classId = scanner.nextLong();

        String result = classService.deleteClass(classId);
        System.out.println(result);
    }
}
