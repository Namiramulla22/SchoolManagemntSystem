package com.School;

import java.util.Scanner;

public class MainOperation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to School Management System");
            System.out.println("Press 1. Student Operations");
            System.out.println("Press 2. Teacher Operations");
            System.out.println("Press 3. Class Operations");
            System.out.println("Press 4. Subject Operations");
            System.out.println("Press 5. Exam Operations");
            System.out.println("Press 6. Result Operations");
            System.out.println("Press 7. Parent Operations");
            System.out.println("Press 8. Attendance Operations");
            System.out.println("Press 9. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    StudentOperation.studentOperations();  // Student operations
                    break;
                case 2:
                    TeacherOperation.teacherOperations();  // Teacher operations
                    break;
                case 3:
                    ClassOperation.classOperations();  // Class operations
                    break;
                case 4:
                    SubjectOperation.subjectOperations();  // Subject operations
                    break;
                case 5:
                    ExamOperation.examOperations();  // Exam operations
                    break;
                case 6:
                    ResultOperation.resultOperations();  // Result operations
                    break;
                case 7:
                    ParentOperation.parentOperations();  // Parent operations
                    break;
                case 8:
                    AttendanceOpreation.attendanceOperations();  // Attendance operations
                    break;
                case 9:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
