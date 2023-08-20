package com.test.development;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

public class DataRetriever {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		//Employee employee = (Employee) session.get(Employee.class, 101);
		
//		Employee employee = session.getReference(Employee.class, 101);
		
		SelectionQuery<?> studentQuery =  session.createSelectionQuery("from Student");
		
		studentQuery.setFirstResult(10);
		studentQuery.setMaxResults(7);
		
		List<Student> students = (List<Student>) studentQuery.getResultList();
		
		students.forEach(System.out::println);
		
//		System.out.println(employee);
		
		session.close();
		
		sessionFactory.close();
	}
}
