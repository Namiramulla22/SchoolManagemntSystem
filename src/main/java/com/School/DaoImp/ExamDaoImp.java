package com.School.DaoImp;

import com.School.Dao.ExamDao;
import com.School.entities.Exam;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Util.HibernateUtil; // Assuming you have a Hibernate utility class for session management
import java.util.List;

public class ExamDaoImp implements ExamDao {

    @Override
    public Exam createExam(Exam exam) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(exam);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return exam; // Returning the created exam
    }

    @Override
    public Exam getExamById(Long examId) {
        Exam exam = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            exam = session.get(Exam.class, examId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam; // Returning the found exam or null if not found
    }

    @Override
    public List<Exam> getAllExams() {
        List<Exam> exams = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            exams = session.createQuery("FROM Exam", Exam.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exams; // Returning the list of exams
    }

    @Override
    public Exam updateExam(Long examId, Exam updatedExam) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Exam existingExam = session.get(Exam.class, examId);
            if (existingExam != null) {
                existingExam.setExamName(updatedExam.getExamName());
                existingExam.setExamDate(updatedExam.getExamDate());
                existingExam.setSubjects(updatedExam.getSubjects());
                session.update(existingExam);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return updatedExam; // Returning the updated exam
    }

    @Override
    public String deleteExam(Long examId) {
        Transaction transaction = null;
        String result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Exam exam = session.get(Exam.class, examId);
            if (exam != null) {
                session.delete(exam);
                result = "Exam deleted successfully";
            } else {
                result = "Exam not found";
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            result = "Error deleting exam";
        }
        return result; // Returning the result message
    }

    @Override
    public List<Exam> getExamsBySubjectId(Long subjectId) {
        List<Exam> exams = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            exams = session.createQuery("SELECT e FROM Exam e JOIN e.subjects s WHERE s.id = :subjectId", Exam.class)
                    .setParameter("subjectId", subjectId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exams; // Returning the list of exams for the specific subject
    }
}
