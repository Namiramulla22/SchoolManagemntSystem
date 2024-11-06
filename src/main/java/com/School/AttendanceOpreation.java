package com.School;

import com.School.Service.AttendanceService;
import com.School.ServiceImp.AttendanceServiceImp;
import com.School.DaoImp.AttendanceDaoImp;
import com.School.entities.Attendance;
import com.School.entities.Student;
import com.School.entities.Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AttendanceOpreation { // Fixed typo here

    private static final AttendanceService attendanceService = new AttendanceServiceImp(new AttendanceDaoImp());
    private static final Scanner scanner = new Scanner(System.in);

    public static void attendanceOperations() {
        while (true) {
            System.out.println("Press 1. Add Attendance");
            System.out.println("Press 2. View All Attendances");
            System.out.println("Press 3. Update Attendance");
            System.out.println("Press 4. Delete Attendance");
            System.out.println("Press 5. View Attendances by Class ID");
            System.out.println("Press 6. View Attendances by Student ID");
            System.out.println("Press 7. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAttendance();
                    break;
                case 2:
                    viewAllAttendances();
                    break;
                case 3:
                    updateAttendance();
                    break;
                case 4:
                    deleteAttendance();
                    break;
                case 5:
                    viewAttendancesByClassId();
                    break;
                case 6:
                    viewAttendancesByStudentId();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Attendance record
    private static void addAttendance() {
        System.out.println("Enter an AttendanceId: ");
        Long attendanceId = scanner.nextLong();

        System.out.println("Enter Attendance Date (yyyy-MM-dd): ");
        String dateString = scanner.next();
        Date attendanceDate = null;
        try {
            attendanceDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        System.out.println("Enter Present Status (P/A): ");
        String status = scanner.next();

        // Validate status
        if (!status.equalsIgnoreCase("P") && !status.equalsIgnoreCase("A")) {
            System.err.println("Invalid status. Please enter 'P' for Present or 'A' for Absent.");
            return;
        }

        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();
        Student student = new Student(studentId, null, null, null, null, null, null, null, null, null, null);  // Check the constructor

        System.out.println("Enter Class ID: ");
        Long classId = scanner.nextLong();
        Class schoolClass = new Class(classId, null, null, null, null);  // Check the constructor

        // Create new Attendance object
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(attendanceId);
        attendance.setDate(attendanceDate); // Date now correctly set as Date type
        attendance.setStatus(status); // Set status as String
        attendance.setStudent(student);
        attendance.setaClass(schoolClass); // Correct class setting

        attendanceService.createAttendance(attendance);
        System.out.println("Attendance added successfully.");
    }

    private static void viewAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        if (attendances.isEmpty()) {
            System.out.println("No attendances found.");
        } else {
            for (Attendance attendance : attendances) {
                System.out.println("Attendance ID: " + attendance.getAttendanceId() +
                        ", Date: " + attendance.getDate() +
                        ", Status: " + attendance.getStatus() +
                        ", Student ID: " + attendance.getStudent().getStudentId() +
                        ", Class ID: " + attendance.getaClass().getClassId()); // Corrected class and ID mapping
            }
        }
    }

    // Update an existing Attendance record
    private static void updateAttendance() {
        System.out.println("Enter Attendance ID to update: ");
        Long attendanceId = scanner.nextLong();

        Attendance attendanceToUpdate = attendanceService.getAttendanceById(attendanceId);
        if (attendanceToUpdate == null) {
            System.out.println("Attendance not found.");
            return;
        }

        System.out.println("Enter new Attendance Date (Current: " + attendanceToUpdate.getDate() + "): ");
        String newAttendanceDate = scanner.next();
        Date parsedDate;
        try {
            parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(newAttendanceDate);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        System.out.println("Enter new Present Status (Current: " + attendanceToUpdate.getStatus() + "): ");
        String newStatus = scanner.next();

        // Validate new status
        if (!newStatus.equalsIgnoreCase("P") && !newStatus.equalsIgnoreCase("A")) {
            System.err.println("Invalid status. Please enter 'P' for Present or 'A' for Absent.");
            return;
        }

        attendanceToUpdate.setDate(parsedDate);
        attendanceToUpdate.setStatus(newStatus);

        attendanceService.updateAttendance(attendanceId, attendanceToUpdate);
        System.out.println("Attendance updated successfully.");
    }

    // Delete an Attendance record
    private static void deleteAttendance() {
        System.out.println("Enter Attendance ID to delete: ");
        Long attendanceId = scanner.nextLong();

        attendanceService.deleteAttendance(attendanceId);
        System.out.println("Attendance deleted successfully.");
    }

    // View Attendance records by Class ID
    private static void viewAttendancesByClassId() {
        System.out.println("Enter Class ID: ");
        Long classId = scanner.nextLong();

        List<Attendance> attendances = attendanceService.getAttendanceByClassId(classId);
        if (attendances.isEmpty()) {
            System.out.println("No attendances found for this class.");
        } else {
            for (Attendance attendance : attendances) {
                System.out.println("Attendance ID: " + attendance.getAttendanceId() +
                        ", Date: " + attendance.getDate() +
                        ", Status: " + attendance.getStatus() +
                        ", Student ID: " + attendance.getStudent().getStudentId());
            }
        }
    }

    // View Attendance records by Student ID
    private static void viewAttendancesByStudentId() {
        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();

        List<Attendance> attendances = attendanceService.getAttendanceByStudentId(studentId);
        if (attendances.isEmpty()) {
            System.out.println("No attendances found for this student.");
        } else {
            for (Attendance attendance : attendances) {
                System.out.println("Attendance ID: " + attendance.getAttendanceId() +
                        ", Date: " + attendance.getDate() +
                        ", Status: " + attendance.getStatus() +
                        ", Class ID: " + attendance.getaClass().getClassId()); // Corrected class ID retrieval
            }
        }
    }
}
