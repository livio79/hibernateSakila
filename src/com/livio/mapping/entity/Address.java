package com.livio.mapping.entity;
//Dalla tabella originale ho cancellato la colonna Location

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*; 
import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="address")
public class Address  implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="district")
	private String district;
	
	@ManyToOne 
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToMany(mappedBy="address")
	List<Store> stores = new ArrayList<>();

	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="phone")
	private String phone;
	
	@UpdateTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	
	@OneToMany(mappedBy="address")
	private List<Customer> customers = new ArrayList<>();
	
	@OneToMany(mappedBy="address")
	private List<Staff> staffs = new ArrayList<>();
	
	
	public Address() {}


	public Address(String address, String address2, String district, String postalCode, String phone) {
		super();
		this.address = address;
		this.address2 = address2;
		this.district = district; 
		this.postalCode = postalCode;
		this.phone = phone;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
		customer.setAddress(this);
	}
	
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.setAddress(null);
	}
	
	public void addStaff(Staff staff) {
		staffs.add(staff);
		staff.setAddress(this);
	}
	
	public void removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setAddress(null);
	}
	
	public void addAStore(Store store){
		stores.add(store);
		store.setAddress(this);
	}
	
	public void removeStore(Store store) {
		stores.remove(store);
		store.setAddress(null);
	}
	
}
