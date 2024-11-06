package com.School.Service;

import com.School.entities.Student;
import com.School.entities.Attendance;
import com.School.entities.Result;

import java.util.List;

public interface StudentService {

    // Student CRUD operations
    Student createStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);

    // Attendance management
    void addAttendance(Long studentId, Attendance attendance);

    List<Attendance> getAttendanceByStudentId(Long studentId);

    Attendance updateAttendance(Long attendanceId, Attendance attendance);

    void deleteAttendance(Long attendanceId);

    // Result management
    void addResult(Long studentId, Result result);

    List<Result> getResultsByStudentId(Long studentId);

    Result updateResult(Long resultId, Result result);

    void deleteResult(Long resultId);
}
