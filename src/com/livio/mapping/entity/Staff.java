package com.livio.mapping.entity;


import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	
//	@Column(name="address_id")
//	private short addressId;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	

	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Column(name="email")
	private String email;
	
	@Column(name="active")
	private byte active;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	//************************************************************ Store 

//	@Column(name="store_id")
//	private byte storeId;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
	
	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}

	
	//************************************************************ Store 
	
	
	


	

	public Staff() {}


	public Staff(String firstName, String lastName, String email, byte active,
			String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.username = username;
		this.password = password;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
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


	public byte getActive() {
		return active;
	}


	public void setActive(byte active) {
		this.active = active;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + " active=" + active + ", username="
				+ username + ", password=" + password + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}
