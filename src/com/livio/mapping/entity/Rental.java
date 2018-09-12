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
	private Inventory inventory;
	
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	//******************************************************Inventory

	
	

	@Column(name="customer_id")
	private short customerId;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@Column(name="staff_id")
	private byte staffId;
	
	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	public Rental() {}

	public Rental(LocalDateTime rentalDate, short customerId, LocalDateTime returnDate, byte staffId) {
		super();
		this.rentalDate = rentalDate;
		this.customerId = customerId;
		this.returnDate = returnDate;
		this.staffId = staffId;
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

	public short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getDatetime() {
		return returnDate;
	}

	public void setDatetime(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public byte getStaffId() {
		return staffId;
	}

	public void setStaffId(byte staffId) {
		this.staffId = staffId;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
