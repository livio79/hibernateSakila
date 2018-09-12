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

public class StoreInventory {

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
		
		 
		Session session = factory.getCurrentSession();
		
 		
 		 
		
		 
		try {		
			session.beginTransaction();
			
	  Store store = session.get(Store.class, 1);         
	  Address address = new Address("ViaUno", "ViaDue", "ABC", "CDE", "1234");
	  City city = session.get(City.class, 1);
	  address.setCity(city);
	  
	  address.addAStore(store);
	  
	 
	  session.save(address);
			 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}



