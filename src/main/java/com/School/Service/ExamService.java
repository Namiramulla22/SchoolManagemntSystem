package com.School.Service;

import com.School.entities.Exam;
import java.util.List;

public interface ExamService {

    // Create a new Exam
    Exam createExam(Exam exam);

    // Retrieve all Exams
    List<Exam> getAllExams();

    // Retrieve a specific Exam by its ID
    Exam getExamById(Long examId);

    // Update an existing Exam
    Exam updateExam(Long examId, Exam updatedExam);

    // Delete an Exam by its ID
    String deleteExam(Long examId);

    // Get Exams by Subject ID (optional, based on your use case)
    List<Exam> getExamsBySubjectId(Long subjectId);
}
