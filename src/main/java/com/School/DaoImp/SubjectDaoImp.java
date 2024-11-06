package com.School.DaoImp;

import com.School.Dao.SubjectDao;
import com.School.entities.Subject;
import com.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SubjectDaoImp implements SubjectDao {

    @Override
    public Subject createSubject(Subject subject) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
            return subject;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating subject: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Subject> query = session.createQuery("FROM Subject", Subject.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving subjects: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Subject subject = session.get(Subject.class, subjectId);
            if (subject == null) {
                throw new RuntimeException("Subject ID not found: " + subjectId);
            }
            return subject;
        } catch (HibernateException e) {
            System.err.println("Error retrieving subject: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Subject updateSubject(Long subjectId, Subject updatedSubject) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Subject subject = session.get(Subject.class, subjectId);
            if (subject == null) {
                throw new RuntimeException("Subject ID not found: " + subjectId);
            }
            subject.setSubjectName(updatedSubject.getSubjectName()); // assuming Subject has a 'name' field
            subject.setExams(updatedSubject.getExams()); // assuming Subject has a mapping to Exams
            session.update(subject);
            transaction.commit();
            return subject;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating subject: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteSubject(Long subjectId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Subject subject = session.get(Subject.class, subjectId);
            if (subject == null) {
                throw new RuntimeException("Subject ID not found: " + subjectId);
            }
            session.delete(subject);
            transaction.commit();
            return "Subject deleted successfully!";
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting subject: " + e.getMessage());
        }
        return "Error deleting subject.";
    }

    @Override
    public List<Subject> getSubjectsByExamId(Long examId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Subject> query = session.createQuery("SELECT s FROM Subject s JOIN s.exams e WHERE e.id = :examId", Subject.class);
            query.setParameter("examId", examId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving subjects by exam ID: " + e.getMessage());
        }
        return null;
    }
}
