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


public class StaffRental {

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
			
 			 Staff staff = new Staff("Rental", "Lulu", "email", (byte)1,"username", "password");
			 Store store = session.get(Store.class, 1);
			 Address address = session.get(Address.class, 1);
			 
			 staff.setStore(store);
			 staff.setAddress(address);
			 
			 
			 LocalDateTime date = LocalDateTime.of(2011, 06, 20, 10, 10, 10);
			 Inventory inventory = session.get(Inventory.class, 1);
			 Customer customer  = session.get(Customer.class, 1);
			 
			 Rental rental = new Rental(date, date);
			 rental.setInventory(inventory);
			 rental.setCustomer(customer);
			 
			 
			 staff.addRental(rental);
			 
 			 session.save(staff);
 			 session.save(rental);
			
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}


