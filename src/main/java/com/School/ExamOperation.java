package com.School;

import com.School.Service.ExamService;
import com.School.ServiceImp.ExamServiceImp;
import com.School.DaoImp.ExamDaoImp;
import com.School.entities.Exam;
import com.School.entities.Subject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExamOperation {

    private static final ExamService examService = new ExamServiceImp(new ExamDaoImp());
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void examOperations() {
        while (true) {
            System.out.println("Press 1. Add Exam");
            System.out.println("Press 2. View All Exams");
            System.out.println("Press 3. Update Exam");
            System.out.println("Press 4. Delete Exam");
            System.out.println("Press 5. View Exams by Subject ID");
            System.out.println("Press 6. Back to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addExam();
                    break;
                case 2:
                    viewAllExams();
                    break;
                case 3:
                    updateExam();
                    break;
                case 4:
                    deleteExam();
                    break;
                case 5:
                    viewExamsBySubjectId();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new Exam
    private static void addExam() {
    	System.out.println("Enter Exam ID: ");
    	Long examId=scanner.nextLong();
    	
        System.out.println("Enter Exam Name: ");
        String examName = scanner.next();

        System.out.println("Enter Exam Date (yyyy-MM-dd): ");
        String examDateStr = scanner.next();
        Date examDate = parseDate(examDateStr);

        // Create new Exam object
        Exam exam = new Exam();
        exam.setExamId(examId);
        exam.setExamName(examName);
        exam.setExamDate(examDate);

        // Add Subjects for the Exam
        System.out.println("Enter number of subjects for the exam: ");
        int subjectCount = scanner.nextInt();
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("Enter Subject ID: ");
            Long subjectId = scanner.nextLong();
            Subject subject = new Subject(subjectId, null, null);  // Assuming Subject has this constructor
            exam.getSubjects().add(subject);  // Add each subject to the Exam's subjects list
        }

        examService.createExam(exam);
        System.out.println("Exam added successfully.");
    }

    // View all Exams
    private static void viewAllExams() {
        List<Exam> exams = examService.getAllExams();
        if (exams.isEmpty()) {
            System.out.println("No exams found.");
        } else {
            for (Exam exam : exams) {
                System.out.println("Exam ID: " + exam.getExamId() +
                        ", Name: " + exam.getExamName() +
                        ", Date: " + dateFormat.format(exam.getExamDate()));
            }
        }
    }

    // Update an existing Exam
    private static void updateExam() {
        System.out.println("Enter Exam ID to update: ");
        Long examId = scanner.nextLong();

        Exam examToUpdate = examService.getExamById(examId);
        if (examToUpdate == null) {
            System.out.println("Exam not found.");
            return;
        }

        System.out.println("Enter new Exam Name (Current: " + examToUpdate.getExamName() + "): ");
        String newExamName = scanner.next();

        System.out.println("Enter new Exam Date (Current: " + dateFormat.format(examToUpdate.getExamDate()) + ", yyyy-MM-dd): ");
        String newExamDateStr = scanner.next();
        Date newExamDate = parseDate(newExamDateStr);

        examToUpdate.setExamName(newExamName);
        examToUpdate.setExamDate(newExamDate);

        examService.updateExam(examId, examToUpdate);
        System.out.println("Exam updated successfully.");
    }

    // Delete an Exam
    private static void deleteExam() {
        System.out.println("Enter Exam ID to delete: ");
        Long examId = scanner.nextLong();

        String response = examService.deleteExam(examId);
        System.out.println(response);
    }

    // View Exams by Subject ID
    private static void viewExamsBySubjectId() {
        System.out.println("Enter Subject ID: ");
        Long subjectId = scanner.nextLong();

        List<Exam> exams = examService.getExamsBySubjectId(subjectId);
        if (exams.isEmpty()) {
            System.out.println("No exams found for this subject.");
        } else {
            for (Exam exam : exams) {
                System.out.println("Exam ID: " + exam.getExamId() +
                        ", Name: " + exam.getExamName() +
                        ", Date: " + dateFormat.format(exam.getExamDate()));
            }
        }
    }

    // Helper method to parse date
    private static Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }
}
