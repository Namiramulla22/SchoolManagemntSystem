package com.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.School.entities.Attendance;
import com.School.entities.Student;


public class HibernateUtil {
	
	private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory()
{

	try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Attendance.class)
				.buildSessionFactory();
		
	}catch (Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}

public static Session getSession()
{
  return getSessionFactory().openSession(); //session opened
}
	
}
