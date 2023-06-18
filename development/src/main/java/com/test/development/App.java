package com.test.development;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Application started");
       
        Configuration configuration = new Configuration();
        
        SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
        
        Employee employee = new Employee(107, "Vishal", "Ahmedabad");
        
        Address address = new Address();
        address.setStreet("Odhav");
        address.setCity("Ahmedabad");
        address.setDateCreated(new Date());
        
        FileInputStream inputStream = new FileInputStream("src/main/java/resources/profile.png");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        
        address.setProfileImage(bytes);
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(employee);
        session.persist(address);
        
        transaction.commit();
        
        session.close();
        
    }
}
