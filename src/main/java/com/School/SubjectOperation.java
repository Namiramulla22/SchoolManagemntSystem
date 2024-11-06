package com.School;

import com.School.DaoImp.SubjectDaoImp;
import com.School.Service.SubjectService;
import com.School.ServiceImp.SubjectServiceImp;
import com.School.entities.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectOperation {

    private static final SubjectService subjectService = new SubjectServiceImp(new SubjectDaoImp());
    private static final Scanner scanner = new Scanner(System.in);

    public static void subjectOperations() {
        while (true) {
            System.out.println("Press 1. Add Subject");
            System.out.println("Press 2. View All Subjects");
            System.out.println("Press 3. Update Subject");
            System.out.println("Press 4. Delete Subject");
            System.out.println("Press 5. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    viewAllSubjects();
                    break;
                case 3:
                    updateSubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Subject
    private static void addSubject() {
        System.out.println("Enter Subject ID");
        scanner.nextLong();
        Long subjectId=scanner.nextLong();
    	
    	System.out.println("Enter Subject Name: ");
        scanner.nextLine(); // consume newline
        String subjectName = scanner.nextLine();

        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        subject.setSubjectName(subjectName);

        subjectService.createSubject(subject);
        System.out.println("Subject added successfully.");
    }

    // View all Subjects
    private static void viewAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        if (subjects == null || subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }
        for (Subject subject : subjects) {
            System.out.println("Subject ID: " + subject.getSubjectId() + ", Subject Name: " + subject.getSubjectName());
        }
    }

    // Update an existing Subject
    private static void updateSubject() {
        System.out.println("Enter Subject ID to update: ");
        Long subjectId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Subject subjectToUpdate = subjectService.getSubjectById(subjectId);
        if (subjectToUpdate == null) {
            System.out.println("Subject not found.");
            return;
        }

        System.out.println("Enter new Subject Name: ");
        String newSubjectName = scanner.nextLine();
        subjectToUpdate.setSubjectName(newSubjectName);

        subjectService.updateSubject(subjectId, subjectToUpdate); // Updated method call
        System.out.println("Subject updated successfully.");
    }

    // Delete a Subject
    private static void deleteSubject() {
        System.out.println("Enter Subject ID to delete: ");
        Long subjectId = scanner.nextLong();

        String response = subjectService.deleteSubject(subjectId); // Updated method call
        System.out.println(response);
    }
}
