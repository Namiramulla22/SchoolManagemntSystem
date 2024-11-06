package com.School.Dao;

import com.School.entities.Subject;

import java.util.List;

public interface SubjectDao {

	 // Create a new Subject
    Subject createSubject(Subject subject);

    // Retrieve all Subjects
    List<Subject> getAllSubjects();

    // Retrieve a specific Subject by its ID
    Subject getSubjectById(Long subjectId);

    // Update an existing Subject
    Subject updateSubject(Long subjectId, Subject updatedSubject);

    // Delete a Subject by its ID
    String deleteSubject(Long subjectId);

    // Get Subjects by Exam ID (optional, based on your use case)
    List<Subject> getSubjectsByExamId(Long examId);
}
