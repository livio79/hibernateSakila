package com.livio.mapping.demo;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.livio.mapping.entity.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 


public class StoreCustomer {

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
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession(); 
		  				
		try {		
 
			session.beginTransaction();
			
			
			
			Store store = session.get(Store.class, 1);
			Address address = session.get(Address.class, 1);
			
			LocalDateTime date = LocalDateTime.of(2018, 10, 10, 10, 10, 10);
			Customer customer = new Customer("Last", "lastName", "email",  (byte)1, date);
			customer.setAddress(address);
			
			store.addCustomer(customer);
			  
			
			session.save(store);
			session.save(customer);
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}


