package com.livio.mapping.entity;

import java.time.LocalDateTime; 
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;
	
	@Column(name="manager_staff_id")
	private byte managerStaffId;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	
	
	//************************************************************Inventory
	 
	@OneToMany(mappedBy="store")
	List<Inventory> inventories = new ArrayList<>();
	
	public void addInventory(Inventory inventory) {
		inventories.add(inventory);
		inventory.setStore(this);
		
	}
	public void removeInventory(Inventory inventory) {
		inventories.remove(inventory);
		inventory.setStore(null);
	}
	 
	//************************************************************Inventory	
	
	//************************************************************Address
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
	
	//************************************************************Address
	
	
	//************************************************************ Staff
	
	@OneToMany(mappedBy="store")
	List<Staff> staffs = new ArrayList<>();
	
	public void addStaff(Staff staff) {
		staffs.add(staff);
		staff.setStore(this);
	}
	
	public void removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setStore(null);
	}
	//************************************************************ Staff

	
	
	 
	
	
	
	public Store() {}
 

//	public Store(byte managerStaffId ) {
//		super();
//		this.managerStaffId = managerStaffId; 
//	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", managerStaffId=" + managerStaffId + "lastUpdate=" + lastUpdate + "]";
	}
}
