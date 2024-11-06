package com.School.Dao;

import com.School.entities.Teacher;

import java.util.List;

public interface TeacherDao {
	// Create a new Teacher
    Teacher createTeacher(Teacher teacher);

    // Retrieve all Teachers
    List<Teacher> getAllTeachers();

    // Retrieve a specific Teacher by its ID
    Teacher getTeacher(Long teacherId);

    // Update an existing Teacher
    Teacher updateTeacher(Long teacherId, Teacher updatedTeacher);

    // Delete a Teacher by its ID
    String deleteTeacher(Long teacherId);

    // Get Teachers by Class ID (optional, based on your use case)
    List<Teacher> getTeachersByClassId(Long classId);

    // Get Teachers by Subject ID (optional, based on your use case)
    List<Teacher> getTeachersBySubjectId(Long subjectId);
}
