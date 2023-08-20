package com.test.development;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestExtractor {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Test test = (Test) session.get(Test.class, 101);
		
		//System.out.println(test.getHelpers().size());
		session.close();
		
		sessionFactory.close();
	}
}
