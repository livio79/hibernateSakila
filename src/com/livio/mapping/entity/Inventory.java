package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime; 
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="inventory")
public class Inventory  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int inventoryId;
	
	@ManyToOne 
	@JoinColumn(name = "film_id")
	private Film film;
	
	@ManyToOne 
	@JoinColumn(name="store_id")
	private Store store;
	
	@OneToMany(mappedBy="inventory")
	List<Rental> rentals = new ArrayList<>();
	
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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
		rental.setInventory(this);
	}
	
	public void removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setInventory(null);
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	 
}
