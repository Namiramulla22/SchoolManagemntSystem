//package com.School;

//import com.School.entities.Student;
/*import com.School.entities.Attendance;
import com.School.Service.StudentService;
import com.School.ServiceImp.StudentServiceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


//public class AllOperation {

    private static final StudentService studentService = new StudentServiceImp();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // CRUD operations for Student
    public static void studentOperations() {
        while (true) {
            System.out.println("Press 1. Add Student");
            System.out.println("Press 2. Retrieve All Students");
            System.out.println("Press 3. Update Student");
            System.out.println("Press 4. Delete Student");
            System.out.println("Press 5. Back to Main Menu");
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
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter Student ID: ");
        Long id = scanner.nextLong();
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

        // Create Student object
        Student student = new Student(id, firstName, lastName, dob, address, email, phone, null);

        // Call service to add student
        studentService.createStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void retrieveAllStudents() {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

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

        Student updatedStudent = new Student(id, firstName, lastName, dob, address, email, phone, null);
        studentService.updateStudent(updatedStudent);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("Enter Student ID to delete: ");
        Long id = scanner.nextLong();
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    // CRUD operations for Attendance
    public static void attendanceOperations() {
        while (true) {
            System.out.println("Press 1. Add Attendance");
            System.out.println("Press 2. View Attendance for a Student");
            System.out.println("Press 3. Back to Main Menu");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAttendance();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    return;  // Exit to the main menu
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addAttendance() {
        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter Attendance Date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        Date date;
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        System.out.println("Enter Attendance Status (Present/Absent): ");
        String status = scanner.nextLine();

        Attendance attendance = new Attendance();
        attendance.setDate(date);
        attendance.setStatus(status);
        attendance.setStudent(student);

        // Add attendance to student
        student.getAttendances().add(attendance);
        studentService.updateStudent(student);

        System.out.println("Attendance added successfully.");
    }

    private static void viewAttendance() {
        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();

        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        // Display all attendances for the student
        System.out.println("Attendances for Student ID: " + studentId);
        if (student.getAttendances() != null) {
            for (Attendance attendance : student.getAttendances()) {
                System.out.println("Date: " + dateFormat.format(attendance.getDate()) + 
                                   ", Status: " + attendance.getStatus());
            }
        } else {
            System.out.println("No attendance records found.");
        }
    }
}
*/