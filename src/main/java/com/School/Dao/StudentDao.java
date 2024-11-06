package com.School.Dao;

import com.School.entities.Student;
import com.School.entities.Attendance;
import com.School.entities.Result;

import java.util.List;

public interface StudentDao {

    // Student CRUD operations
    Student createStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);

    // Attendance operations for a student
    void addAttendance(Long studentId, Attendance attendance);

    List<Attendance> getAttendanceByStudentId(Long studentId);

    Attendance updateAttendance(Long studentId, Long attendanceId, Attendance attendance);

    void deleteAttendance(Long studentId, Long attendanceId);

    // Result operations for a student
    void addResult(Long studentId, Result result);

    List<Result> getResultsByStudentId(Long studentId);

    Result updateResult(Long studentId, Long resultId, Result result);

    void deleteResult(Long studentId, Long resultId);
}
