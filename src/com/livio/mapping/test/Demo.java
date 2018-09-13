package com.livio.mapping.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import com.livio.mapping.*;
import com.livio.mapping.entity.*;
import com.livio.utility.HibernateUtil;

public class Demo {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.createSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
				
		
		String q2 = "SELECT s.firstName, s.lastName, s.address FROM Staff s";
			
		TypedQuery<Object[]> query2 = session.createQuery(q2);

		List<Object[]> result2 = query2.getResultList();
		
		 
		
		
	    System.out.println(result2.get(0)[0] + " " +  result2.get(0)[1] );
////	    
////		
//		for(int i = 0; i< result2.size(); i++)
//			System.out.println(result2.get(i)[0]);
	 
		session.getTransaction().commit();
		
		sessionFactory.close();
	}

}
