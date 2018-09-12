package com.livio.mapping.entity;

import java.time.LocalDateTime;
import java.util.*; 
import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;
//Dalla tabella originale ho cancellato la colonna Location
@Entity
@Table(name="address")
public class Address {
	
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
	//************************************************************City
	//ManyToOne - Costruttore: elimina cityId - Country city getter setter
//	@Column(name="city_id")
//	private short cityId;
	
	@ManyToOne 
	@JoinColumn(name = "city_id")
	private City city;
	
	
	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}
	
	//************************************************************City
	
	//************************************************************Store

	@OneToMany(mappedBy="address")
	List<Store> stores = new ArrayList<>();

	public void addAStore(Store store){
		stores.add(store);
		store.setAddress(this);
	}
	
	public void removeStore(Store store) {
		stores.remove(store);
		store.setAddress(null);
	}
	
	
	
	
	//************************************************************Store

	

	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="phone")
	private String phone;
	
	@UpdateTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	
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


//	public short getCityId() {
//		return cityId;
//	}
//
//
//	public void setCityId(short cityId) {
//		this.cityId = cityId;
//	}


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
	
	
}
