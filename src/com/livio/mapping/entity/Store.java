package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime; 
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="store")
public class Store  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;
	
	@Column(name="manager_staff_id")
	private byte managerStaffId;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	 
	@OneToMany(mappedBy="store")
	List<Inventory> inventories = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy="store")
	List<Staff> staffs = new ArrayList<>();
	
	@OneToMany(mappedBy="store")
	private List<Customer> customers = new ArrayList<>();
	
	
	
	public Store() {}
 

	
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public void addInventory(Inventory inventory) {
		inventories.add(inventory);
		inventory.setStore(this);
		
	}
	public void removeInventory(Inventory inventory) {
		inventories.remove(inventory);
		inventory.setStore(null);
	}
	 
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addStaff(Staff staff) {
		staffs.add(staff);
		staff.setStore(this);
	}
	
	public void removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setStore(null);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
		customer.setStore(this);
	}
	
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.setStore(null);
	}

	public byte getManagerStaff() {
		return managerStaffId;
	}

	public void setManagerStaff(byte managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
