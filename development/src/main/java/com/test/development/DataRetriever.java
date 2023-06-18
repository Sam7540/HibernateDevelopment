package com.test.development;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataRetriever {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Employee employee = (Employee) session.get(Employee.class, 101);
		
		System.out.println(employee);
		
		session.close();
		
		sessionFactory.close();
	}
}
