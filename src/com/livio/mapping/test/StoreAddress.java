package com.livio.mapping.test;

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

public class StoreAddress {

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
		//Film film = new Film("Store3", "Language", "2010",(byte)2, (byte) 1, (byte)2, 2.4, (short) 1, 2.0, "PG", "Trailers");
		Store store = null;
		
		 
		try {		
 
		
			
			
			
			
			
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}



