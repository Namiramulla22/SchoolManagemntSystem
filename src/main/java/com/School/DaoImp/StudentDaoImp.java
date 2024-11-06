package com.School.DaoImp;

import com.School.Dao.StudentDao;
import com.School.entities.Student;
import com.School.entities.Attendance;
import com.School.entities.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImp implements StudentDao {

    private final Map<Long, Student> studentDatabase = new HashMap<>();
    private final Map<Long, List<Attendance>> attendanceDatabase = new HashMap<>();
    private final Map<Long, List<Result>> resultDatabase = new HashMap<>();
    private Long studentIdCounter = 1L; // Counter for generating student IDs
    private Long attendanceIdCounter = 1L; // Counter for generating attendance IDs
    private Long resultIdCounter = 1L; // Counter for generating result IDs

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
        attendanceDatabase.remove(studentId); // Optionally remove attendance records
        resultDatabase.remove(studentId); // Optionally remove result records
    }

    // Attendance operations for a student
    @Override
    public void addAttendance(Long studentId, Attendance attendance) {
        if (!studentDatabase.containsKey(studentId)) {
            throw new RuntimeException("Student not found with id " + studentId);
        }
        attendance.setAttendanceId(attendanceIdCounter++);
        attendance.setStudent(getStudentById(studentId)); // Set the student for this attendance
        attendanceDatabase.putIfAbsent(studentId, new ArrayList<>());
        attendanceDatabase.get(studentId).add(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceDatabase.getOrDefault(studentId, new ArrayList<>());
    }

    @Override
    public Attendance updateAttendance(Long studentId, Long attendanceId, Attendance attendance) {
        List<Attendance> attendances = attendanceDatabase.get(studentId);
        if (attendances != null) {
            for (int i = 0; i < attendances.size(); i++) {
                if (attendances.get(i).getAttendanceId().equals(attendanceId)) {
                    attendance.setAttendanceId(attendanceId); // Ensure the ID is set
                    attendances.set(i, attendance);
                    return attendance; // Return the updated attendance
                }
            }
        }
        throw new RuntimeException("Attendance not found with id " + attendanceId);
    }

    @Override
    public void deleteAttendance(Long studentId, Long attendanceId) {
        List<Attendance> attendances = attendanceDatabase.get(studentId);
        if (attendances != null) {
            boolean removed = attendances.removeIf(attendance -> attendance.getAttendanceId().equals(attendanceId));
            if (!removed) {
                throw new RuntimeException("Attendance not found with id " + attendanceId);
            }
        } else {
            throw new RuntimeException("No attendance records found for student with id " + studentId);
        }
    }

    // Result operations for a student
    @Override
    public void addResult(Long studentId, Result result) {
        if (!studentDatabase.containsKey(studentId)) {
            throw new RuntimeException("Student not found with id " + studentId);
        }
        result.setResultId(resultIdCounter++);
        result.setStudent(getStudentById(studentId)); // Set the student for this result
        resultDatabase.putIfAbsent(studentId, new ArrayList<>());
        resultDatabase.get(studentId).add(result);
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultDatabase.getOrDefault(studentId, new ArrayList<>());
    }

    @Override
    public Result updateResult(Long studentId, Long resultId, Result result) {
        List<Result> results = resultDatabase.get(studentId);
        if (results != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getResultId().equals(resultId)) {
                    result.setResultId(resultId); // Ensure the ID is set
                    results.set(i, result);
                    return result; // Return the updated result
                }
            }
        }
        throw new RuntimeException("Result not found with id " + resultId);
    }

    @Override
    public void deleteResult(Long studentId, Long resultId) {
        List<Result> results = resultDatabase.get(studentId);
        if (results != null) {
            boolean removed = results.removeIf(result -> result.getResultId().equals(resultId));
            if (!removed) {
                throw new RuntimeException("Result not found with id " + resultId);
            }
        } else {
            throw new RuntimeException("No result records found for student with id " + studentId);
        }
    }
}
