package com.School.DaoImp;

import com.School.Dao.ClassDao;
import com.School.entities.Class;
import com.Util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClassDaoimp implements ClassDao {

	@Override
	public Class createClass(Class classes) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(classes);
	        transaction.commit();
	        return classes;
	    } catch (HibernateException e) {
	        if (transaction != null) {
	            try {
	                transaction.rollback();
	            } catch (Exception rollbackEx) {
	                System.err.println("Error during rollback: " + rollbackEx.getMessage());
	            }
	        }
	        System.err.println("Error creating class: " + e.getMessage());
	    } catch (Exception ex) {
	        System.err.println("General error: " + ex.getMessage());
	    }
	    return null;
	}

	@Override
	public List<Class> getAllClasses() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        List<Class> classes = session.createQuery("FROM Class", Class.class).list();
	        for (Class clazz : classes) {
	            Hibernate.initialize(clazz.getStudents());  // Manually initialize students collection
	        }
	        return classes;
	    } catch (HibernateException e) {
	        System.err.println("Error retrieving classes: " + e.getMessage());
	    }
	    return null;
	}


    @Override
    public Class getClassById(Long classId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Class classes = session.get(Class.class, classId);
            if (classes == null) {
                throw new RuntimeException("Class ID not found: " + classId);
            }
            return classes;
        } catch (HibernateException e) {
            System.err.println("Error retrieving class: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Class updateClass(Long classId, Class updatedClass) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Class classes = session.get(Class.class, classId);
            if (classes == null) {
                throw new RuntimeException("Class ID not found: " + classId);
            }
            classes.setName(updatedClass.getName());
            classes.setTeacher(updatedClass.getTeacher());
            classes.setStudents(updatedClass.getStudents());
            session.update(classes);
            transaction.commit();
            return classes;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating class: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteClass(Long classId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Class classes = session.get(Class.class, classId);
            if (classes == null) {
                throw new RuntimeException("Class ID not found: " + classId);
            }
            session.delete(classes);
            transaction.commit();
            return "Class deleted successfully!";
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting class: " + e.getMessage());
        }
        return "Error deleting class.";
    }

    @Override
    public List<Class> getClassesByTeacherId(Long teacherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Class> query = session.createQuery("FROM Class c WHERE c.teacher.id = :teacherId", Class.class);
            query.setParameter("teacherId", teacherId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving classes by teacher ID: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Class> getClassesByStudentId(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Class> query = session.createQuery("SELECT c FROM Class c JOIN c.students s WHERE s.id = :studentId", Class.class);
            query.setParameter("studentId", studentId);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving classes by student ID: " + e.getMessage());
        }
        return null;
    }
}
