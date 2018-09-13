package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="rental")
public class Rental  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int rentalId;
	
	@Column(name="rental_date")
	private LocalDateTime rentalDate;
	
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@OneToMany(mappedBy="rental")
	private List<Payment> payments = new ArrayList<>();
	
	
	
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
			return staff;
		}
	
	public void setStaff(Staff staff) {
		this.staff = staff;
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
	
	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setRental(this);
	}
	
	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.setRental(null);
	}
}
