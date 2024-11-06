package com.School.Dao;

import com.School.entities.Attendance;
import java.util.List;

public interface AttendanceDao {

    // Create a new Attendance record
    Attendance createAttendance(Attendance attendance);

    // Retrieve all Attendance records
    List<Attendance> getAllAttendances();

    // Retrieve a specific Attendance by its ID
    Attendance getAttendanceById(Long attendanceId);

    // Update an existing Attendance record
    Attendance updateAttendance(Long attendanceId, Attendance updatedAttendance);

    // Delete an Attendance record by its ID
    String deleteAttendance(Long attendanceId);

    // Get all Attendance records by Class ID
    List<Attendance> getAttendanceByClassId(Long classId);

    // Get all Attendance records by Student ID
    List<Attendance> getAttendanceByStudentId(Long studentId);
}
