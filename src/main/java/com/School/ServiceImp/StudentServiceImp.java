package com.School.ServiceImp;

import com.School.Service.StudentService;
import com.School.entities.Student;
import com.School.entities.Attendance;
import com.School.entities.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImp implements StudentService {

    private final Map<Long, Student> studentDatabase = new HashMap<>();
    private final Map<Long, List<Attendance>> attendanceDatabase = new HashMap<>();
    private final Map<Long, List<Result>> resultDatabase = new HashMap<>();
    private Long studentIdCounter = 1L; // Simple counter for generating student IDs
    private Long attendanceIdCounter = 1L; // Counter for Attendance IDs
    private Long resultIdCounter = 1L; // Counter for Result IDs

    // Student CRUD operations
    @Override
    public Student createStudent(Student student) {
        student.setStudentId(studentIdCounter++);
        studentDatabase.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentDatabase.get(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDatabase.values());
    }

    @Override
    public Student updateStudent(Student student) {
        if (!studentDatabase.containsKey(student.getStudentId())) {
            throw new RuntimeException("Student not found with id " + student.getStudentId());
        }
        studentDatabase.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public void deleteStudent(Long studentId) {
        if (!studentDatabase.containsKey(studentId)) {
            throw new RuntimeException("Student not found with id " + studentId);
        }
        studentDatabase.remove(studentId);
    }

    // Attendance management
    @Override
    public void addAttendance(Long studentId, Attendance attendance) {
        attendance.setAttendanceId(attendanceIdCounter++); // Set a unique ID for attendance
        attendance.setStudent(getStudentById(studentId)); // Associate with the student
        attendanceDatabase.putIfAbsent(studentId, new ArrayList<>());
        attendanceDatabase.get(studentId).add(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceDatabase.getOrDefault(studentId, new ArrayList<>());
    }

    @Override
    public Attendance updateAttendance(Long attendanceId, Attendance attendance) {
        List<Attendance> attendances = attendanceDatabase.get(attendance.getStudent().getStudentId());
        if (attendances != null) {
            for (int i = 0; i < attendances.size(); i++) {
                if (attendances.get(i).getAttendanceId().equals(attendanceId)) {
                    attendances.set(i, attendance);
                    return attendance; // Return the updated attendance
                }
            }
        }
        throw new RuntimeException("Attendance not found with id " + attendanceId);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        for (List<Attendance> attendances : attendanceDatabase.values()) {
            attendances.removeIf(attendance -> attendance.getAttendanceId().equals(attendanceId));
        }
    }

    // Result management
    @Override
    public void addResult(Long studentId, Result result) {
        result.setResultId(resultIdCounter++); // Set a unique ID for the result
        result.setStudent(getStudentById(studentId)); // Associate with the student
        resultDatabase.putIfAbsent(studentId, new ArrayList<>());
        resultDatabase.get(studentId).add(result);
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultDatabase.getOrDefault(studentId, new ArrayList<>());
    }

    @Override
    public Result updateResult(Long resultId, Result result) {
        List<Result> results = resultDatabase.get(result.getStudent().getStudentId());
        if (results != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getResultId().equals(resultId)) {
                    results.set(i, result);
                    return result; // Return the updated result
                }
            }
        }
        throw new RuntimeException("Result not found with id " + resultId);
    }

    @Override
    public void deleteResult(Long resultId) {
        for (List<Result> results : resultDatabase.values()) {
            results.removeIf(result -> result.getResultId().equals(resultId));
        }
    }
}
