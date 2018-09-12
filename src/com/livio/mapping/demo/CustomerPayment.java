package com.livio.mapping.demo;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.livio.mapping.entity.*;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 


public class CustomerPayment {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Actor.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(City.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Film.class)
				.addAnnotatedClass(Inventory.class)
				.addAnnotatedClass(Language.class)
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(Rental.class)
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(Store.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession(); 
		
		  
		try {		
 
			session.beginTransaction();
			
			 LocalDateTime date = LocalDateTime.of(2011, 06, 20, 10, 10, 10);
			 Staff staff = session.get(Staff.class, 1);
			 Rental rental = session.get(Rental.class, 1);
			 
//			 
//			 Payment payment = new Payment( 1, 2.0, date);
//			 payment.setStaff(staff);
//			 
//			 
//			 
//			 Store store = session.get(Store.class, 1);
//			 Address address = session.get(Address.class, 1);
//			 
//			 Customer customer = new Customer("Rental", "lastName", "email",(byte) 1, date);
//			 customer.setStore(store);
//			 customer.setAddress(address);
//			 
//			 customer.addPayment(payment);
//			 
//			 
//			  
// 			 session.save(customer);
// 			 session.save(payment);
			
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}


