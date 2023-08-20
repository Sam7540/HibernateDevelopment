package com.test.development;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class TestExecutor {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		TestHelper helper = new TestHelper(201, "First Helper");
		TestHelper helper2 = new TestHelper(202, "Second Helper");
		
		
		
		Test test = new Test(101, "test numbers", true, List.of(1,2,3,4,5,6), List.of(helper, helper2));
		
		Session session = sessionFactory.openSession();
		
//		MutationQuery query = session.createMutationQuery("");
		
		
		
		Transaction transaction = session.beginTransaction();
		
		session.persist(test);
		session.persist(helper);
		session.persist(helper2);
		
		if(session.contains(test)) {
			System.out.println("Session contains test object");
		}
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
}
