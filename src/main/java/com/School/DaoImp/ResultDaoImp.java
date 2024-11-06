package com.School.DaoImp;

import com.School.Dao.ResultDao;
import com.School.entities.Result;
import com.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ResultDaoImp implements ResultDao {

    @Override
    public Result createResult(Result result) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(result);
            transaction.commit();
            return result; // Returning the created result
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating result: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    @Override
    public List<Result> getAllResults() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Result> query = session.createQuery("FROM Result", Result.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving results: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    @Override
    public Result getResultById(Long resultId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Result result = session.get(Result.class, resultId);
            if (result == null) {
                throw new RuntimeException("Result ID not found: " + resultId);
            }
            return result;
        } catch (HibernateException e) {
            System.err.println("Error retrieving result: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    @Override
    public Result updateResult(Long resultId, Result updatedResult) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Result result = session.get(Result.class, resultId);
            if (result == null) {
                throw new RuntimeException("Result ID not found: " + resultId);
            }
            // Update fields of the existing result
            result.setMarksObtained(updatedResult.getMarksObtained());
            result.setSubject(updatedResult.getSubject());
            result.setStudent(updatedResult.getStudent());
            session.update(result);
            transaction.commit();
            return result; // Return updated result
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating result: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    @Override
    public String deleteResult(Long resultId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Result result = session.get(Result.class, resultId);
            if (result == null) {
                throw new RuntimeException("Result ID not found: " + resultId);
            }
            session.delete(result);
            transaction.commit();
            return "Result deleted successfully!"; // Return success message
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting result: " + e.getMessage());
        }
        return "Error deleting result."; // Return error message if deletion fails
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Result> query = session.createQuery("FROM Result r WHERE r.student.id = :studentId", Result.class);
            query.setParameter("studentId", studentId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving results by student ID: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    @Override
    public List<Result> getResultsBySubjectId(Long subjectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Result> query = session.createQuery("FROM Result r WHERE r.subject.id = :subjectId", Result.class);
            query.setParameter("subjectId", subjectId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving results by subject ID: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }
}
