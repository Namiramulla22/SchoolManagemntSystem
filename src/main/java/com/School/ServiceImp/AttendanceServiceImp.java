package com.School.ServiceImp;

import com.School.Service.AttendanceService;
import com.School.Dao.AttendanceDao;
import com.School.DaoImp.AttendanceDaoImp;
import com.School.entities.Attendance;

import java.util.List;

public class AttendanceServiceImp implements AttendanceService {

    // Declare a reference to AttendanceDao
    AttendanceDao attendanceDao=new AttendanceDaoImp();

    // Constructor-based dependency injection for AttendanceDao
    public AttendanceServiceImp(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;  // Inject AttendanceDao implementation via the constructor
    }

    // Create a new Attendance record
    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceDao.createAttendance(attendance);  // Call the DAO method to persist the Attendance entity
    }

    // Retrieve all Attendance records
    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceDao.getAllAttendances();  // Fetch all attendances from the DAO
    }

    // Retrieve a specific Attendance record by its ID
    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return attendanceDao.getAttendanceById(attendanceId);  // Find attendance by its ID using the DAO
    }

    // Update an existing Attendance record
    @Override
    public Attendance updateAttendance(Long attendanceId, Attendance updatedAttendance) {
        return attendanceDao.updateAttendance(attendanceId, updatedAttendance);  // Update the attendance record in the DAO
    }

    // Delete an Attendance record by its ID
    @Override
    public String deleteAttendance(Long attendanceId) {
        return attendanceDao.deleteAttendance(attendanceId);  // Call the DAO method to delete an Attendance by ID
    }

    // Get all Attendance records for a specific Class by Class ID
    @Override
    public List<Attendance> getAttendanceByClassId(Long classId) {
        return attendanceDao.getAttendanceByClassId(classId);  // Fetch attendances associated with a specific class
    }

    // Get all Attendance records for a specific Student by Student ID
    @Override
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceDao.getAttendanceByStudentId(studentId);  // Fetch attendances associated with a specific student
    }
}
