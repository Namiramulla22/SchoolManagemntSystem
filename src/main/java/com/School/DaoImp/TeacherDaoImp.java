package com.School.DaoImp;

import com.School.Dao.TeacherDao;
import com.School.Exception.ResourceNotFoundException;
import com.School.entities.Teacher;
import com.Util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDaoImp implements TeacherDao {

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            return teacher;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating teacher: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving teachers: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Teacher getTeacher(Long teacherId) {
        try (Session session = HibernateUtil.getSession()) {
            Teacher teacher = session.get(Teacher.class, teacherId);
            if (teacher == null) {
                throw new ResourceNotFoundException("Teacher ID not found: " + teacherId);
            }
            return teacher;
        } catch (HibernateException e) {
            System.err.println("Error retrieving teacher: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Teacher existingTeacher = session.get(Teacher.class, teacherId);
            
            if (existingTeacher == null) {
                throw new ResourceNotFoundException("Teacher ID not found: " + teacherId);
            }
            
            existingTeacher.setFullname(updatedTeacher.getFullname());
            existingTeacher.setClasses(updatedTeacher.getClasses());
            existingTeacher.setSubjects(updatedTeacher.getSubjects());
            
            session.update(existingTeacher);
            transaction.commit();
            return existingTeacher;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating teacher: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteTeacher(Long teacherId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, teacherId);
            if (teacher == null) {
                throw new ResourceNotFoundException("Teacher ID not found: " + teacherId);
            }
            session.delete(teacher);
            transaction.commit();
            return "Teacher deleted successfully!";
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting teacher: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return "Error deleting teacher.";
    }

    @Override
    public List<Teacher> getTeachersByClassId(Long classId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Teacher> query = session.createQuery("FROM Teacher t WHERE :classId MEMBER OF t.classes", Teacher.class);
            query.setParameter("classId", classId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving teachers by class: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Teacher> getTeachersBySubjectId(Long subjectId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Teacher> query = session.createQuery("FROM Teacher t WHERE :subjectId MEMBER OF t.subjects", Teacher.class);
            query.setParameter("subjectId", subjectId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving teachers by subject: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }
}
