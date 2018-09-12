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

public class RentalInventory {

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
		 
		LocalDateTime date = LocalDateTime.of(2011, 06, 20, 10, 10, 10);
		
		 
		try {		
			session.beginTransaction();
			
		 Rental rental = new Rental(date, (short)1, date, (byte)1);
		 Inventory inventory = new Inventory();
		 Film film = session.get(Film.class, 1);
		 Store store = session.get(Store.class, 1);
		 
		 inventory.setFilm(film);
		 inventory.setStore(store);
		 inventory.setInventoryId(1);
		 inventory.addRental(rental);
		 
 		 session.save(rental);
			
			 
			
		 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}



