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


public class AddressStaff {

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
			
			 Staff staff = new Staff("AddressStaff", "Lulu", "email", (byte)1,"username", "password");
			 Store store = session.get(Store.class, 1);
			 staff.setStore(store);
			 
			 Address address = new Address("AddressStaff", "47 MySakila Drive2", "Alberta", "PCode", "Phone");
			 
			 City city = session.get(City.class, 1);
			 address.setCity(city);
			
			 address.addStaff(staff);
			 
			 session.save(address);
			 session.save(staff);
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}


