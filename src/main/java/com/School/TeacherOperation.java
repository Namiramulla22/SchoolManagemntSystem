package com.School;

import com.School.Dao.TeacherDao;
import com.School.DaoImp.TeacherDaoImp;
import com.School.Service.TeacherService;
import com.School.ServiceImp.TeacherServiceImp;
import com.School.entities.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherOperation {

    // Declare a TeacherDao variable
    private static final TeacherDao teacherDao = new TeacherDaoImp();
    
    // Use the teacherDao variable to initialize TeacherService
    private static final TeacherService teacherService = new TeacherServiceImp(teacherDao);
    private static final Scanner scanner = new Scanner(System.in);

    public static void teacherOperations() {
        while (true) {
            System.out.println("Press 1. Add Teacher");
            System.out.println("Press 2. View All Teachers");
            System.out.println("Press 3. Update Teacher");
            System.out.println("Press 4. Delete Teacher");
            System.out.println("Press 5. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    viewAllTeachers();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    deleteTeacher();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Teacher
    private static void addTeacher() {
        System.out.println("Enter Teacher ID: ");
        Long teacherId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        System.out.println("Enter Teacher Full Name: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter Teacher Specialization: ");
        String specialization = scanner.nextLine();

        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setFullname(fullName);
        teacher.setSpecialization(specialization);

        teacherService.createTeacher(teacher);
        System.out.println("Teacher added successfully.");
    }

    // View all Teachers
    private static void viewAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println("Teacher ID: " + teacher.getTeacherId() + ", Name: " + teacher.getFullname() +
                    ", Specialization: " + teacher.getSpecialization());
        }
    }

    // Update an existing Teacher
    private static void updateTeacher() {
        System.out.println("Enter Teacher ID to update: ");
        Long teacherId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Teacher teacherToUpdate = teacherService.getTeacher(teacherId);
        if (teacherToUpdate == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.println("Enter new Full Name: ");
        String newFullName = scanner.nextLine();

        System.out.println("Enter new Specialization: ");
        String newSpecialization = scanner.nextLine();

        teacherToUpdate.setFullname(newFullName);
        teacherToUpdate.setSpecialization(newSpecialization);
        teacherService.updateTeacher(teacherId, teacherToUpdate);
        System.out.println("Teacher updated successfully.");
    }

    // Delete a Teacher
    private static void deleteTeacher() {
        System.out.println("Enter Teacher ID to delete: ");
        Long teacherId = scanner.nextLong();

        teacherService.deleteTeacher(teacherId);
        System.out.println("Teacher deleted successfully.");
    }
}
