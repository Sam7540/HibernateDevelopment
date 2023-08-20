package com.test.development;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.github.javafaker.Faker;


public class StudentApp {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Faker faker = new Faker();
		
		Transaction transaction =  session.beginTransaction();
		
		
		for (int i = 0; i < 50; i++) {
			Student student = new Student(faker.name().firstName(), faker.programmingLanguage().name(), i+1, faker.address().city());
			session.persist(student);
		}
		
		transaction.commit();
		
		session.close();
	}
}
