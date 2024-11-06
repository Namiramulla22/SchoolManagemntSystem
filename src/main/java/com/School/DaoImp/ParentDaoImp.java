package com.School.DaoImp;

import com.School.Dao.ParentDao;
import com.School.entities.Parent;
import com.School.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Util.HibernateUtil; // Assuming you have a Hibernate utility class for session management
import java.util.List;

public class ParentDaoImp implements ParentDao {

    @Override
    public Parent createParent(Parent parentEntity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(parentEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of error
            }
            e.printStackTrace(); // Log the error
        }
        return parentEntity; // Return the saved parent entity
    }

    @Override
    public Parent getParentById(Long parentId) {
        Parent parent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            parent = session.get(Parent.class, parentId);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        }
        return parent;
    }

    @Override
    public List<Parent> getAllParents() {
        List<Parent> parents = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            parents = session.createQuery("FROM Parent", Parent.class).list();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        }
        return parents;
    }

    @Override
    public Parent updateParent(Long parentId, Parent updatedParent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            updatedParent.setParentId(parentId); // Ensure the ID is set for the entity
            session.update(updatedParent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of error
            }
            e.printStackTrace(); // Log the error
        }
        return updatedParent; // Return the updated parent entity
    }

    @Override
    public String deleteParent(Long parentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Parent parent = session.get(Parent.class, parentId);
            if (parent != null) {
                session.delete(parent);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of error
            }
            e.printStackTrace(); // Log the error
        }
        return "Parent with ID " + parentId + " deleted successfully"; // Return success message
    }

    @Override
    public List<Student> getStudentsByParentId(Long parentId) {
        List<Student> students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            students = session.createQuery("SELECT s FROM Student s WHERE s.parent.parentId = :parentId", Student.class)
                              .setParameter("parentId", parentId)
                              .getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        }
        return students; // Return the list of students associated with the parent
    }
}
