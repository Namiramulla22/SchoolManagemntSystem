package com.School;

import com.School.Service.ParentService;
import com.School.ServiceImp.ParentServiceImp;
import com.School.DaoImp.ParentDaoImp;
import com.School.entities.Parent;
import com.School.entities.Student;

import java.util.List;
import java.util.Scanner;

public class ParentOperation {

    private static final ParentService parentService = new ParentServiceImp(new ParentDaoImp());
    private static final Scanner scanner = new Scanner(System.in);

    public static void parentOperations() {
        while (true) {
            System.out.println("Press 1. Add Parent");
            System.out.println("Press 2. View All Parents");
            System.out.println("Press 3. Update Parent");
            System.out.println("Press 4. Delete Parent");
            System.out.println("Press 5. View Students by Parent ID");
            System.out.println("Press 6. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addParent();
                    break;
                case 2:
                    viewAllParents();
                    break;
                case 3:
                    updateParent();
                    break;
                case 4:
                    deleteParent();
                    break;
                case 5:
                    viewStudentsByParentId();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Parent
    private static void addParent() {
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();

        System.out.println("Enter Email: ");
        String email = scanner.next();

        System.out.println("Enter Phone Number: ");
        String phone = scanner.next();

        // Create new Parent object
        Parent parent = new Parent();
        parent.setFirstName(firstName);
        parent.setLastName(lastName);
        parent.setEmail(email);
        parent.setPhone(phone);

        parentService.createParent(parent);
        System.out.println("Parent added successfully.");
    }

    // View all Parents
    private static void viewAllParents() {
        List<Parent> parents = parentService.getAllParents();
        if (parents.isEmpty()) {
            System.out.println("No parents found.");
        } else {
            for (Parent parent : parents) {
                System.out.println("Parent ID: " + parent.getParentId() +
                        ", Name: " + parent.getFirstName() + " " + parent.getLastName() +
                        ", Email: " + parent.getEmail() +
                        ", Phone: " + parent.getPhone());
            }
        }
    }

    // Update an existing Parent
    private static void updateParent() {
        System.out.println("Enter Parent ID to update: ");
        Long parentId = scanner.nextLong();

        Parent parentToUpdate = parentService.getParentById(parentId);
        if (parentToUpdate == null) {
            System.out.println("Parent not found.");
            return;
        }

        System.out.println("Enter new First Name (Current: " + parentToUpdate.getFirstName() + "): ");
        String newFirstName = scanner.next();

        System.out.println("Enter new Last Name (Current: " + parentToUpdate.getLastName() + "): ");
        String newLastName = scanner.next();

        System.out.println("Enter new Email (Current: " + parentToUpdate.getEmail() + "): ");
        String newEmail = scanner.next();

        System.out.println("Enter new Phone (Current: " + parentToUpdate.getPhone() + "): ");
        String newPhone = scanner.next();

        // Set updated values
        parentToUpdate.setFirstName(newFirstName);
        parentToUpdate.setLastName(newLastName);
        parentToUpdate.setEmail(newEmail);
        parentToUpdate.setPhone(newPhone);

        parentService.updateParent(parentId, parentToUpdate);
        System.out.println("Parent updated successfully.");
    }

    // Delete a Parent
    private static void deleteParent() {
        System.out.println("Enter Parent ID to delete: ");
        Long parentId = scanner.nextLong();

        String response = parentService.deleteParent(parentId);
        System.out.println(response);
    }

    // View Students by Parent ID
    private static void viewStudentsByParentId() {
        System.out.println("Enter Parent ID: ");
        Long parentId = scanner.nextLong();

        List<Student> students = parentService.getStudentsByParentId(parentId);
        if (students.isEmpty()) {
            System.out.println("No students found for this parent.");
        } else {
            for (Student student : students) {
                System.out.println("Student ID: " + student.getStudentId() +
                        ", Name: " + student.getFirstName() + " " + student.getLastName() +
                        ", Grade: " + student.getPhone());
            }
        }
    }
}
