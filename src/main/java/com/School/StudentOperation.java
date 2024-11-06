package com.School;

import com.School.Service.StudentService;
import com.School.ServiceImp.StudentServiceImp;
import com.School.entities.Class;
import com.School.entities.Parent;
import com.School.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentOperation {

    private static final StudentService studentService = new StudentServiceImp();
    private static final Scanner scanner = new Scanner(System.in);

    // Method to handle all student operations
    public static void studentOperations() {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Retrieve All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back to Main Menu");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    retrieveAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;  // Return to main menu
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Method to add a student
    private static void addStudent() {
        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter DOB (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();

        // Get associated Class
        System.out.println("Enter Class ID for the Student: ");
        Long classId = scanner.nextLong();
        Class aClass = new Class();
        aClass.setClassId(classId);

        // Get associated Parent
        System.out.println("Enter Parent ID for the Student: ");
        Long parentId = scanner.nextLong();
        Parent parent = new Parent();
        parent.setParentId(parentId);

        // Create Student object
        Student student = new Student(studentId, firstName, lastName, dob, address, email, phone, aClass, parent, new ArrayList<>(), new ArrayList<>());

        // Call the service to add the student
        studentService.createStudent(student);
        System.out.println("Student added successfully.");
    }

    // Method to retrieve all students
    private static void retrieveAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to update a student
    private static void updateStudent() {
        System.out.println("Enter Student ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Updated First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter Updated Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Updated DOB: ");
        String dob = scanner.nextLine();

        System.out.println("Enter Updated Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Updated Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Updated Phone: ");
        String phone = scanner.nextLine();

        // Update associated Class
        System.out.println("Enter Updated Class ID for the Student: ");
        Long classId = scanner.nextLong();
        Class aClass = new Class();
        aClass.setClassId(classId);

        // Update associated Parent
        System.out.println("Enter Updated Parent ID for the Student: ");
        Long parentId = scanner.nextLong();
        Parent parent = new Parent();
        parent.setParentId(parentId);

        Student updatedStudent = new Student(id, firstName, lastName, dob, address, email, phone, aClass, parent, new ArrayList<>(), new ArrayList<>());
        studentService.updateStudent(updatedStudent);
        System.out.println("Student updated successfully.");
    }

    // Method to delete a student
    private static void deleteStudent() {
        System.out.println("Enter Student ID to delete: ");
        Long id = scanner.nextLong();
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}
