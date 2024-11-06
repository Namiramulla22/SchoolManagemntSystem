package com.School.DaoImp;

import com.School.Dao.AttendanceDao;
import com.School.entities.Attendance;
import com.Util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AttendanceDaoImp implements AttendanceDao {

    @Override
    public Attendance createAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(attendance); // Save the attendance
            transaction.commit();
            return attendance;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error creating attendance: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Attendance> getAllAttendances() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Attendance", Attendance.class).list(); // Retrieve all attendances
        } catch (HibernateException e) {
            System.err.println("Error retrieving attendances: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Attendance.class, attendanceId); // Find attendance by ID
        } catch (HibernateException e) {
            System.err.println("Error retrieving attendance: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Attendance updateAttendance(Long attendanceId, Attendance updatedAttendance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Attendance existingAttendance = session.get(Attendance.class, attendanceId);
            if (existingAttendance != null) {
                existingAttendance.setDate(updatedAttendance.getDate());
                existingAttendance.setStatus(updatedAttendance.getStatus());
                existingAttendance.setStudent(updatedAttendance.getStudent()); // Update ManyToOne Student mapping
                existingAttendance.setaClass(updatedAttendance.getaClass());   // Update ManyToOne Class mapping
                session.update(existingAttendance); // Save the changes
                transaction.commit();
                return existingAttendance;
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating attendance: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteAttendance(Long attendanceId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Attendance attendance = session.get(Attendance.class, attendanceId);
            if (attendance != null) {
                session.delete(attendance); // Delete the attendance
                transaction.commit();
                return "Attendance record deleted successfully";
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting attendance: " + e.getMessage());
        }
        return "Attendance record not found";
    }

    @Override
    public List<Attendance> getAttendanceByClassId(Long classId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Attendance> query = session.createQuery("FROM Attendance a WHERE a.aClass.id = :classId", Attendance.class);
            query.setParameter("classId", classId);
            return query.list(); // Retrieve attendance records by Class ID
        } catch (HibernateException e) {
            System.err.println("Error retrieving attendances by Class ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Attendance> query = session.createQuery("FROM Attendance a WHERE a.student.id = :studentId", Attendance.class);
            query.setParameter("studentId", studentId);
            return query.list(); // Retrieve attendance records by Student ID
        } catch (HibernateException e) {
            System.err.println("Error retrieving attendances by Student ID: " + e.getMessage());
        }
        return null;
    }
}
