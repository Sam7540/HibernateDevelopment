package com.test.development;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
        
        Employee manager = new Employee();
        manager.setEmpid(109);
        manager.setEmpName("Harsh");
        manager.setCity("Ahmedabad");
        
        Employee HOD = new Employee();
        HOD.setEmpid(110);
        HOD.setEmpName("Soumyajit");
        HOD.setCity("Gandhinagar");
        
        Project feeManagementSystem = new Project(1212, "Fee Management System", new Date(), List.of(manager, HOD));
        Project libraryManagementSystem = new Project(1213, "Library Management System", new Date(), List.of(HOD));
        
        manager.setProjects(List.of(feeManagementSystem));
        HOD.setProjects(List.of(feeManagementSystem, libraryManagementSystem));
        
//        Trainee trainee1 = new Trainee(201, "trainee1", "Java", manager);
//        Trainee trainee2 = new Trainee(202, "trainee2", "PHP", manager);
//        Trainee trainee3 = new Trainee(203, "trainee3", ".Net", manager);
        
//        manager.setTrainees(List.of(trainee1, trainee2, trainee3));
        
//        Employee employee = new Employee(109, "Vipul", "Ahmedabad", List.of(trainee1, trainee2, trainee3));
//        
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
        
        session.persist(manager);
        session.persist(HOD);
        session.persist(feeManagementSystem);
        session.persist(libraryManagementSystem);
//        session.persist(trainee1);
//        session.persist(trainee2);
//        session.persist(trainee3);
        
        transaction.commit();
        
        session.close();
        
    }
}
