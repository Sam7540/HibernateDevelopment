package com.test.development;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

public class HQLQuery {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		
		SessionFactory sessionFactory = configuration.configure("configurations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		//MutationQuery query = session.createMutationQuery("from Employee where city=Ahmedabad");
		
		
		@SuppressWarnings("unchecked")
		SelectionQuery<Object> query = (SelectionQuery<Object>) session.createSelectionQuery("select emp.empName,pr.projectName from (select e.empName,ep.projectId from Employee e inner join e.empProjects ep on e.empid = ep.employeeId where e.empid = :employeeId) emp inner join Project pr on emp.projectId = pr.projectId");
		
		query.setParameter("employeeId", "110");
		
		List<Object> employees = query.getResultList();
		
		for (Object employee : employees) {
			System.out.println(employee.toString());
		}
		
		session.close();
		
		sessionFactory.close();
	}
}
