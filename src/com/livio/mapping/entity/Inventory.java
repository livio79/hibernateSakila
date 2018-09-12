package com.livio.mapping.entity;

import java.time.LocalDateTime; 
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int inventoryId;
	
	
	
	//************************************************************Film
	
//		@Column(name="film_id")
//		private int filmId;
		
		@ManyToOne 
		@JoinColumn(name = "film_id")
		private Film film;
		
		public Film getFilm() {
			return film;
		}


		public void setFilm(Film film) {
			this.film = film;
		}
	 

		//************************************************************Film
	
		//************************************************************Store

//	@Column(name="store_id")
//	private int storeId;
		
		@ManyToOne 
		private Store store;
		
		public Store getStore() {
			return store;
		}


		public void setStore(Store store) {
			this.store = store;
		}
		
		
	//************************************************************Store
		
	//************************************************************Rental
	
	@OneToMany(mappedBy="inventory")
	List<Rental> rentals = new ArrayList<>();
	
	public void addRental(Rental rental) {
		rentals.add(rental);
		rental.setInventory(this);
	}
	
	public void removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setInventory(null);
	}
	
		
		
	//************************************************************Rental

	
	


	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	
	public Inventory() {}

 
	public int getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	} 


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	 
}
