package com.School;

import com.School.Service.ResultService;
import com.School.ServiceImp.ResultServiceImp;
import com.School.DaoImp.ResultDaoImp;
import com.School.entities.Result;
import com.School.entities.Student;
import com.School.entities.Subject;

import java.util.List;
import java.util.Scanner;

public class ResultOperation {

    private static final ResultService resultService = new ResultServiceImp(new ResultDaoImp());
    private static final Scanner scanner = new Scanner(System.in);

    public static void resultOperations() {
        while (true) {
            System.out.println("Press 1. Add Result");
            System.out.println("Press 2. View All Results");
            System.out.println("Press 3. Update Result");
            System.out.println("Press 4. Delete Result");
            System.out.println("Press 5. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addResult();
                    break;
                case 2:
                    viewAllResults();
                    break;
                case 3:
                    updateResult();
                    break;
                case 4:
                    deleteResult();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Result
    private static void addResult() {
    	System.out.println("Enter Result ID: ");
    	Long resultId=scanner.nextLong();
    	
        System.out.println("Enter Marks Obtained: ");
        Double marksObtained = scanner.nextDouble();

        System.out.println("Enter Total Marks: ");
        Double totalMarks = scanner.nextDouble();

        System.out.println("Enter Grade: ");
        String grade = scanner.next();

        System.out.println("Enter Student ID: ");
        Long studentId = scanner.nextLong();
        Student student = new Student();
        student.setStudentId(studentId);

        System.out.println("Enter Subject ID: ");
        Long subjectId = scanner.nextLong();
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);

        // Create new Result object
        Result result = new Result();
        result.setResultId(resultId);
        result.setMarksObtained(marksObtained);
        result.setTotalMarks(totalMarks);
        result.setGrade(grade);
        result.setStudent(student);
        result.setSubject(subject);

        resultService.createResult(result);
        System.out.println("Result added successfully.");
    }

    // View all Results
    private static void viewAllResults() {
        List<Result> results = resultService.getAllResults();
        if (results == null || results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Result result : results) {
                System.out.println("Result ID: " + result.getResultId() +
                        ", Marks Obtained: " + result.getMarksObtained() +
                        ", Total Marks: " + result.getTotalMarks() +
                        ", Grade: " + result.getGrade() +
                        ", Student ID: " + result.getStudent().getStudentId() +
                        ", Subject ID: " + result.getSubject().getSubjectId());
            }
        }
    }

    // Update an existing Result
    private static void updateResult() {
        System.out.println("Enter Result ID to update: ");
        Long resultId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Result resultToUpdate = resultService.getResultById(resultId);
        if (resultToUpdate == null) {
            System.out.println("Result not found.");
            return;
        }

        System.out.println("Enter new Marks Obtained (Current: " + resultToUpdate.getMarksObtained() + "): ");
        Double newMarksObtained = scanner.nextDouble();

        System.out.println("Enter new Total Marks (Current: " + resultToUpdate.getTotalMarks() + "): ");
        Double newTotalMarks = scanner.nextDouble();

        System.out.println("Enter new Grade (Current: " + resultToUpdate.getGrade() + "): ");
        String newGrade = scanner.next();

        resultToUpdate.setMarksObtained(newMarksObtained);
        resultToUpdate.setTotalMarks(newTotalMarks);
        resultToUpdate.setGrade(newGrade);

        resultService.updateResult(resultId, resultToUpdate);
        System.out.println("Result updated successfully.");
    }

    // Delete a Result
    private static void deleteResult() {
        System.out.println("Enter Result ID to delete: ");
        Long resultId = scanner.nextLong();

        String response = resultService.deleteResult(resultId);
        System.out.println(response);
    }
}
