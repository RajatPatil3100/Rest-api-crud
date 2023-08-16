package com.prowings.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.entity.Student;

@Repository
public abstract class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveStudent(Student std) {
		
		boolean result = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			session.save(std);
			txn.commit();
			session.close();
			result = true;
		}
		catch (Exception e) {
			System.out.println("Error occurred while storing the student : "+e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Student getStudent(int id) {
		Student std = null;
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		std = session.get(Student.class, id);
		
		txn.commit();
		session.close();
		
		return std;
	}
	
	@Override
	public List<Student> getStudents(){
		
		Session session = sessionFactory.openSession();
		Transaction tx= null;
		List<Student> stdList = null;
		try {
			
			tx =session.beginTransaction();
			Query<Student> query = session.createQuery("from Student");
			stdList = query.list();
			tx.commit();
		}catch(HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace(System.err);
		} 
		finally 
		{
			session.close();
			return stdList;
		}
	}
	
}

