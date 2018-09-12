package com.livio.mapping.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="rental")
public class Rental {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int rentalId;
	
	@Column(name="rental_date")
	private LocalDateTime rentalDate;
	
	
	//******************************************************Inventory
	
//	@Column(name="inventory_id")
//	private int inventoryId;
	
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	//******************************************************Inventory

	
	

//	@Column(name="customer_id")
//	private short customerId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	


	@Column(name="return_date")
	private LocalDateTime returnDate;
	
//	@Column(name="staff_id")
//	private byte staffId;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	public Rental() {}

	public Rental(LocalDateTime rentalDate, LocalDateTime returnDate) {
		super();
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDateTime getDatetime() {
		return returnDate;
	}

	public void setDatetime(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
