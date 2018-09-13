package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp; 

@Entity
@Table(name="customer")
public class Customer  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;

	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@Column(name="active")
	private byte active;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@OneToMany(mappedBy="customer")
	private List<Rental> rentals = new ArrayList<>();
	
	@OneToMany(mappedBy="customer")
	private List<Payment> payments = new ArrayList<>();
	
	
	public Customer() {}

	public Customer(String firstName, String lastName, String email, byte active,	LocalDateTime createDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.createDate = createDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
		rental.setCustomer(this);
	}
	
	public void removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setCustomer(null);
	}
	
	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setCustomer(this);
	}
	
	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.setCustomer(null);
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
