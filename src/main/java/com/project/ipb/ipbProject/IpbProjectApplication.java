package com.project.ipb.ipbProject;

import com.project.ipb.ipbProject.hibernateTools.HibernateDBUtil;
import com.project.ipb.ipbProject.hibernateTools.HibernateUtil;
import com.project.ipb.ipbProject.model.Estimate;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class IpbProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpbProjectApplication.class, args);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Estimate estimate = new Estimate();
		estimate.setCost(124.45);
		session.beginTransaction();
		session.save(estimate);


		Estimate estimate1 = new Estimate();
		estimate1.setCost(245.12);
		session.save(estimate1);
		session.getTransaction().commit();
//		List<Estimate> list = session.createQuery("from estimate").list();
//		System.out.println(list);
//
		session.close();
	}

}
